package com.example.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        System.out.println("Main Controller");
        return "index";
    }
}
