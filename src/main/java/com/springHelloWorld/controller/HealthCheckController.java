package com.springHelloWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/health")
public class HealthCheckController {
    @RequestMapping(
            path = "/check",
            method = RequestMethod.GET
    )
    public @ResponseBody String hello(){
        return "Health is Ok";
    }
}