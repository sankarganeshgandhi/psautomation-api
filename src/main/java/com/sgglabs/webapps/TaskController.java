package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all Task related operations
 *
 * @author Sankarganesh Gandhi (sankarganesh.gandhi@gmail.com)
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    private static final String SPACE = " ";

    @Autowired
    TaskRepository taskRepo;

    @Autowired
    ScriptRepository scriptRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    /**
     * Get all tasks
     * @return
     */
    @GetMapping
    public List<Task> getAllTasks() {
        List<Task> tasksList = new ArrayList<>();
        for (Task task : taskRepo.findAll()) {
            tasksList.add(task);
        }
        return tasksList;
    }

    /**
     * Get a Task by Id
     * @param taskId
     * @return
     */
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable Long taskId) {
        return taskRepo.findById(taskId).get();
    }

    /**
     * Submit a Task for approval
     * @param task
     * @return
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    /**
     * Update Task details
     * @param taskId
     * @param task
     * @return
     */
    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskRepo.save(task);
    }

    /**
     * Approve a given Task
     * @param taskId
     * @param user
     * @return
     */
    @PutMapping("/{taskId}/approve")
    public ResponseEntity updateTaskApprove(@PathVariable Long taskId, @RequestBody User user) {
        User requestingUser = userRepo.findById(user.getId()).get();
        Role role = roleRepo.findById(requestingUser.getRoleId()).get();
        boolean canExecute = false;
        for (Permission permission : role.getPermissions()) {
            if (permission.getName().equalsIgnoreCase(PermissionEnum.Approve.getString())) {
                canExecute = true;
                break;
            }
        }
        ResponseEntity resEntity = null;
        if (canExecute) {
            Task task = updateTaskStatus(taskId, StatusEnum.Approved);
            resEntity = new ResponseEntity(task, HttpStatus.OK);
        } else {
            String msg = "User " + user.toString() + " do not have permission";
            LOG.error(msg);
            resEntity = new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }

    /**
     * Reject a given Task
     * @param taskId
     * @param user
     * @return
     */
    @PutMapping("/{taskId}/reject")
    public Task updateTaskReject(@PathVariable Long taskId, @RequestBody User user) {
        return updateTaskStatus(taskId, StatusEnum.Rejected);
    }

    /**
     * Run a given Task
     * @param taskId
     * @param user
     * @return
     */
    @PutMapping("/{taskId}/run")
    public ResponseEntity runTask(@PathVariable Long taskId, @RequestBody User user) {
        Task task = taskRepo.findById(taskId).get();

        if (task.getStatusId() == StatusEnum.Approved.getValue()) {
            Script script = scriptRepo.findById(task.getScriptId()).get();

            String[] inputValues = task.getInputValues().split(",");
            List<String> valueList = new ArrayList<String>();
            for (String inputValue : inputValues) {
                String value = inputValue.substring(1, inputValue.length() - 1);
                LOG.debug("(*******" + value + "*******)");
                valueList.add(value);
            }

            MessageFormat msgFormat = new MessageFormat(script.getInputTemplate());
            String finalInputValues = msgFormat.format(valueList.toArray());

            StringBuffer sysCmdBuffer = new StringBuffer(script.getScriptCommand());
            sysCmdBuffer.append(SPACE)
                    .append(script.getScriptDirPath())
                    .append(File.separatorChar)
                    .append(script.getScriptFileName())
                    .append(SPACE)
                    .append(finalInputValues);

            LOG.debug("(*******" + sysCmdBuffer.toString() + "*******)");

            try {
                Process sysProc = Runtime.getRuntime().exec(sysCmdBuffer.toString());

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(sysProc.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(sysProc.getErrorStream()));

                // read the output from the command

                LOG.info("Here is the standard output of the command:\n");
                StringBuffer outputBuffer = new StringBuffer();
                String streamLine;
                while ((streamLine = stdInput.readLine()) != null) {
                    outputBuffer.append(streamLine).append(System.lineSeparator());
                }
                LOG.info(outputBuffer.toString());

                // read any errors from the attempted command
                outputBuffer.delete(0, outputBuffer.toString().length());
                LOG.error("Here is the standard error of the command (if any):\n");
                while ((streamLine = stdError.readLine()) != null) {
                    outputBuffer.append(streamLine).append(System.lineSeparator());
                }
                LOG.error(outputBuffer.toString());
            } catch(IOException ioe){
                LOG.debug(ioe.getMessage(), ioe.fillInStackTrace());
            }
        } else {
            String msg = "Task is not approved to run";
            LOG.error(msg);
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /*
     * update the status of the given Task based on StatusEnum passed
     */
    private Task updateTaskStatus(Long taskId, StatusEnum statusEnum) {
        Task task = taskRepo.findById(taskId).get();
        task.setStatusId(statusEnum.getValue());
        return taskRepo.save(task);
    }
}