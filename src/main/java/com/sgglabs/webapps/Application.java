package com.sgglabs.webapps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

/**
 * Application for API tier for PS automation
 *
 * @author Sankarganesh
 */
public class Application {
    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        final Thread mainThread = Thread.currentThread();
        runtime.addShutdownHook(new Thread() {
            public void run() {
            // close your resources here before calling interrupt
            mainThread.interrupt();
            }
        });

        //initialize your application here
        AppConfig.init();
        init();
    }

    private static void init() {
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFiles.location("/public");
        port(Integer.parseInt(AppConfig.get(AppConfig.APP_SERVICE_PORT)));

        get("/resource1", (req, res) -> {
            //call appropriate business method
            res.header("content-type", "application/json");
            res.status(200);
            return "";
        });

        post("/resource1", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });

        put("/resource1/:id", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });

        put("/resource1/:id/member-resource2", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });

        delete("/resource1/:id", (req, res) -> {
            //call appropriate business method
            res.status(200);
            return "";
        });

        delete("/resources", (req, res) -> {
            try {
                //call appropriate business method
                res.status(200);
            } catch (Exception ex) {
                res.status(404);
            }
            return "";
        });
    }
}