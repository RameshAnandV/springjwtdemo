package com.example.springjwtdemo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorld {
    @GetMapping("/print")
    public String returnHelloWorld() {
        return "Hello World";
    }
}
