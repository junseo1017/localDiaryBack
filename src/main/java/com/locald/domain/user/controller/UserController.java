package com.locald.domain.user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/main")
    public String getMainPage(Model model) {
        try {
            Thread.sleep(2000);
            return "on";
        } catch (Exception e) {
            throw new RuntimeException("This is a deliberate exception.");
        }
    }

    @GetMapping("/user/signin")
    public String signin(Model model) {
        try {
            Thread.sleep(1000);
            return "token";
        } catch (Exception e) {
            throw new RuntimeException("This is a deliberate exception.");
        }
    }

    @PostMapping("/user/signup")
    public String signup(Model model) {
        try {
            return "token";
        } catch (Exception e) {
            throw new RuntimeException("This is a deliberate exception.");
        }
    }
}