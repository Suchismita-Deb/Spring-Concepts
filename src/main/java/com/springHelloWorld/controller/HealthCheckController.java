package com.springHelloWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/health")
public class HealthCheckController {

    @RequestMapping(
            path = "/check",
            method = RequestMethod.GET
    )    public @ResponseBody String checkHealth() {
        return "Health is Ok";
    }
}