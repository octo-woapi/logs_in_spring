package com.example.poclog.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {

    Logger logger = LoggerFactory.getLogger(ClassA.class);
    @Autowired
    ClassB classB;

    public void methodA() throws InterruptedException {
        logger.info("entering A");
        Thread.sleep(2000);
        classB.methodB();
        logger.info("leaving A");
    }

}
