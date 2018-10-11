package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.StatusEnum;
import com.sgglabs.webapps.model.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    TaskRepository taskRepo;

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

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskRepo.save(task);
    }

    @PutMapping("/{taskId}/approve")
    public Task updateTaskApprove(@PathVariable Long taskId, @RequestBody User user) {
        return updateTaskStatus(taskId, StatusEnum.Approved);
    }

    @PutMapping("/{taskId}/reject")
    public Task updateTaskReject(@PathVariable Long taskId, @RequestBody User user) {
        return updateTaskStatus(taskId, StatusEnum.Rejected);
    }

    private Task updateTaskStatus(Long taskId, StatusEnum statusEnum) {
        Task task = taskRepo.findById(taskId).get();
        task.setStatusId(statusEnum.getValue());
        return task;
    }
}