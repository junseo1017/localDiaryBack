package com.locald.domain.user.controller;

import com.locald.domain.user.domain.User;
import com.locald.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/main")
    public String getMainPage() {
        try {
            User user = new User();
            Long saveId = userService.save();
            return saveId.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
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