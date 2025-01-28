package com.example.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        System.out.println("Home Method Invoked");
        return "Spring Boot VS Code Demo Application";
    }
    
}
