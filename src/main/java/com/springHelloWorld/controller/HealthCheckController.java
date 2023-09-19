package com.springHelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/healthCheck")
    public String hello(){
        return "Health is Ok";
    }
}
