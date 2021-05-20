package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    
    @RequestMapping("1234")
    public String helloWord() {
        return "Hello world";
    }
}

