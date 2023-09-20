package com.springHelloWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
