package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
 
@Controller
public class TestController {
	
	private static final String template = "Hello, %s!";
    
	private static String name;
	
    @RequestMapping("/login")
    public String login() {
          return "test2";
    }
    
    @RequestMapping("/output")
  
    //@RequestParam(value="username") 与 test2 name一致！！！
    public String test6(@RequestParam(value="username") String s) {
    	  System.out.print(s + "\n");
    	  name = s;
          return "redirect:/hello";
    }
    
    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map, Model model) {
        model.addAttribute("say", name);
        map.put("hello", "Hello");
        return "test3";
    }
}


