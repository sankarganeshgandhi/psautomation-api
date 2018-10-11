package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.Task;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * TaskApplication for API tier for PS automation
 *
 * @author Sankarganesh Gandhi (sankarganesh.gandhi@gmail.com)
 */
@SpringBootApplication
public class TaskApplication {
    private final static Logger logger = LoggerFactory.getLogger(TaskApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaskApplication.class);
        app.run(args);
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