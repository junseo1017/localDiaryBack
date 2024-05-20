package com.locald.domain.user.controller;

import com.locald.domain.user.domain.User;
import com.locald.domain.user.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    @ResponseBody
    public User singIn(@RequestBody User user) {
        try {
            log.info("user={}",user);
            User accessUser = userService.signIn(user);
            return accessUser;
        } catch (Exception e) {
            throw new RuntimeException("This is a deliberate exception.");
        }
    }

    @PostMapping("/user/signup")
    public String addUser(Model model) {
        try {
            return "token";
        } catch (Exception e) {
            throw new RuntimeException("This is a deliberate exception.");
        }
    }


    /**
     * Test Method
     */
    @PostConstruct
    public void CreateData(){
        User user = User.builder().email("test@test.com").password("123").name("test1").build();
        userService.addUser(user);
    }
}