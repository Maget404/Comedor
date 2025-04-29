package com.example.Comedor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class JorgeTestController {

    @GetMapping("jorgetest")
    public String jorgetest() {
        return "Jorge Test";
    }
}
