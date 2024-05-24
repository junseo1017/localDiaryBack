package com.locald.domain.user.controller;

import com.locald.domain.user.domain.User;
import com.locald.domain.user.dto.UserSigninForm;
import com.locald.domain.user.exception.UserException;
import com.locald.domain.user.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public Object singIn(@Validated @RequestBody UserSigninForm user) throws UserException {
        try {
        User loginUser = userService.signIn(user);
        if (loginUser == null) {
            throw new UserException("該当データ無し");
        }
        return null;
        } catch(RuntimeException rEx){
            log.error("rEx={}",rEx);
            throw new RuntimeException("サーバーエラー");
        } catch(Exception ex){
            log.error("rEx={}",ex);
            throw new RuntimeException("サーバーエラー");
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
    public void CreateData() {
        User user = User.builder().email("test@test.com").password("123").name("test1").build();
        userService.addUser(user);
    }
}