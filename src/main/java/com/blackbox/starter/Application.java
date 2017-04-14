package com.blackbox.starter;

import com.blackbox.starter.controllers.EventController;
import com.blackbox.starter.util.file.FileMonitorDemo;

//@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {

        EventController eventController = new EventController();
        FileMonitorDemo fileListener = new FileMonitorDemo(eventController);

    }

}
