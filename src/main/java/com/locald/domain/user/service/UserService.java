package com.locald.domain.user.service;

import com.locald.domain.user.repository.UserRepository;
import com.locald.domain.user.domain.User;
import com.locald.domain.user.dto.UserSigninForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User signIn(UserSigninForm user){
        User findUser = userRepository.getUsersByEmailAndPassword(user.getEmail(), user.getPassword());
        return findUser;
    }

}
