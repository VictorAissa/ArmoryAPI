package com.victor.armoryapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArmoryController {
    @GetMapping("/items")
    public String helloWorld() {
        return "All the stuff !";
    }
}