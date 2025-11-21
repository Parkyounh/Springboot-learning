package com.example.gatewayservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/myorder")
    public String myorder(){
        return "myorder";
    }

    @GetMapping("/orderstatus")
    public String orderstatus(){
        return "orderstatus";
    }
}
