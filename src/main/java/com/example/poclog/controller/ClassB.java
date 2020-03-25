package com.example.poclog.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ClassB {

    Logger logger = LoggerFactory.getLogger(ClassB.class);

    public void methodB() throws InterruptedException {
        logger.info("entering B");
        Thread.sleep(1000);
        logger.info("leaving B");
    }
}
