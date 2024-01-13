package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalDiaryController {
    @GetMapping(value = "/test")
    public String getTest(Model model) {
        return "Hello";
    }

    @GetMapping(value = "/main")
    public String getMainPage(Model model) {
        try {
            Thread.sleep(2000);
            return "on";
        } catch (Exception e) {
            return "on";
        }
    }
}