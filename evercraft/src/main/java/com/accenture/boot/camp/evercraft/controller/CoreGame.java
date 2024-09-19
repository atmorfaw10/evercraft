package com.accenture.boot.camp.evercraft.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class CoreGame {
    public CoreGame(){}

    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello, World";
    }

    @GetMapping("/person")
    public String getHelloName(@RequestParam("name") String name) {
        return name == null ? "Hello, World" : "Hello, " + name;
    }
}
