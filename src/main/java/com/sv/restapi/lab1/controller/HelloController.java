package com.sv.restapi.lab1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello/welcome")
    public String sayHi(){
        return  "Hi Welcome to REST API";
    }
}
