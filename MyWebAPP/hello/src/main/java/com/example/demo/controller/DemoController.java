package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
public class DemoController {

    private static final String template = "Hello, %s!";
    
    @RequestMapping("/user")
    public User dealTest(@RequestParam(value="name", defaultValue="World") String name) {
    	System.out.print("Name: " + name + '\n');
        return new User(String.format(template, name));
    }@RequestMapping("/")
    public String defaultHandler(){
        return "Hello~";
    }
    

}
