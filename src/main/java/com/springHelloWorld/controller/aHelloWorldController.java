package com.springHelloWorld.controller;

import com.springHelloWorld.model.HelloWorldReturnBean;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nichaurasia on Saturday, December/07/2019 at 3:00 PM
 */
@RestController
@RequestMapping("/api/v0/hello-world")
public class aHelloWorldController {

    @RequestMapping(method= RequestMethod.GET,path="/requestMapping")
    public String helloWorldViaRequestMapping() {
        return "Hello World - From requestMapping";
    }

    @GetMapping(path="/getMapping")
    public String helloWorldViaGetMapping() {
        return "Hello World - From getMapping";
    }

    @GetMapping(path="/getBean")
    public HelloWorldReturnBean helloWorldReturnBean() {
        return new HelloWorldReturnBean("Hello World - From HelloWorldReturnBean");
    }

    @GetMapping(path = "/pathVariable/{var_name}")
    public String helloWorldPathVariable(@PathVariable("var_name") String name) {
        return String.format("The Value returned is %s", name);
    }
}