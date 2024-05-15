package com.locald.domain.user.service;

import com.locald.domain.user.dao.UserRepository;
import com.locald.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired UserRepository userRepository;

    public Long save(){
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("123");
        Long saveId = userRepository.save(user);
        return saveId;
    }
}
