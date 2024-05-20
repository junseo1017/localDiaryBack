package com.locald.domain.user.service;

import com.locald.domain.user.dao.UserRepository;
import com.locald.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public User signIn(User user){
        User findUser = userRepository.getUsersByEmailAndPassword(user.getEmail(), user.getPassword());
        log.debug("findUser={}",findUser);
        if(findUser==null){
            return null;
        } else {
            return findUser;
        }
    }

}
