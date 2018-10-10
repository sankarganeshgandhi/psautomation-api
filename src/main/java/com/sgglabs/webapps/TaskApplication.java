package com.sgglabs.webapps;

import com.google.common.collect.Lists;
import com.sgglabs.webapps.model.entity.Task;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

import static spark.Spark.*;

/**
 * TaskApplication for API tier for PS automation
 *
 * @author Sankarganesh
 */
@SpringBootApplication
public class TaskApplication {
    private final static Logger logger = LoggerFactory.getLogger(TaskApplication.class);

    @Autowired
    TaskRepository taskRepo;

    private static TaskRepository staticTaskRepo;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        /*Runtime runtime = Runtime.getRuntime();
        final Thread mainThread = Thread.currentThread();
        runtime.addShutdownHook(new Thread() {
            public void run() {
            // close your resources here before calling interrupt
                mainThread.interrupt();
            }
        });*/

        //initialize your application here
        //AppConfig.init();
        TaskApplication.init();
    }

    @PostConstruct
    public void postConstructInit() {
        TaskApplication.staticTaskRepo = taskRepo;
    }

    private static void init() {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFiles.location("/public");
        port(9090);//Integer.parseInt(AppConfig.get(AppConfig.APP_SERVICE_PORT)));

        /**
         * Get list of all tasks
         */
        get("/tasks", (req, res) -> {
            List<Task> taskList = Lists.newArrayList(staticTaskRepo.findAll());
            res.header("content-type", "application/json");
            res.status(200);
            return taskList;
        });

        /**
         * Create/Submit a task. A task can be submitted by a role that has appropriate permission
         */
        post("/tasks", (req, res) -> {
            staticTaskRepo.save(new Task());
            res.status(200);
            return "";
        });

        /**
         * A task can be modified, by appropriate role/permission
         */
        put("/tasks/:id", (req, res) -> {
            staticTaskRepo.save(new Task());
            res.status(200);
            return "";
        });

        /**
         * A task can be approved, by appropriate role/permission
         */
        put("/tasks/:id/approve", (req, res) -> {
            staticTaskRepo.save(new Task());
            res.status(200);
            return "";
        });

        /**
         * A task can be rejected, by appropriate role/permission
         */
        put("/tasks/:id/reject", (req, res) -> {
            staticTaskRepo.save(new Task());
            res.status(200);
            return "";
        });

        /**
         * A task can be run, by appropriate role/permission
         */
        put("/tasks/:id/run", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });

        /*put("/resource1/:id/member-resource2", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });*/

        /**
         * Expire a Task
         */
        delete("/tasks/:id", (req, res) -> {
            res.status(200);
            return "";
        });

        /**
         * Expire all the tasks
         */
        delete("/tasks", (req, res) -> {
            try {
                //call appropriate business method
                res.status(200);
            } catch (Exception ex) {
                res.status(404);
            }
            return "";
        });
    }

    private static String getJSON(List<Task> taskList) {
        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(taskList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return jsonString;
    }
}