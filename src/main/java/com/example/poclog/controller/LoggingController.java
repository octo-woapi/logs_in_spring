package com.example.poclog.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

/*
https://www.baeldung.com/spring-boot-logging
 */

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    ClassA classA;

    @GetMapping("/")

    public String displayBasicLogs(@RequestAttribute(name = "password", required = false) String password){
        try {
            classA.methodA();
        } catch (InterruptedException e) {
            logger.error("something went wrong calling A");
            e.printStackTrace();
        }
        return "Done";
    }


}
