package com.developmate.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@RestController
public class DocumentController {
    public DocumentController() {
    }

    @GetMapping("/")
    public String getHelloWorld() {
        return "Root endpoint";
    }

    @GetMapping("/test")
    public String getMenu() {
        return "Server works!";
    }
}
