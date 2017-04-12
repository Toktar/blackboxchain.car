package com.blackbox.starter;

import com.blackbox.starter.controllers.EventController;
import com.blackbox.starter.util.file.FileMonitorDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {

        EventController eventController = new EventController();
        FileMonitorDemo fileListener = new FileMonitorDemo(eventController);

    }

}
