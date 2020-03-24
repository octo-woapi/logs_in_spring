package com.example.poclog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logController {

    @GetMapping("/")
    public String displayBasicLogs(){
        

        return "Check my logs bro !";
    }
}
