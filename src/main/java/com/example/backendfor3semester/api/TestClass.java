package com.example.backendfor3semester.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {

    @GetMapping()
    public String getname(){
        return "hej";
    }
}
