package com.yash.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/")
    public String displayHome(){
        return "You are at home";
    }

    @GetMapping("/secure")
    public String displaySecurePage(){
        return "secure.html";
    }

}
