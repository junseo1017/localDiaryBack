package com.locald.domain.user.dao;

import com.locald.domain.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {
    @Autowired UserRepository userRepository;

    @Test
    public void testUserCreate() throws Exception {
        //given
        User user = new User();
        user.setEmail("test@test.com");

        //when
        Long saveId = userRepository.save(user);
        User findUser = userRepository.find(saveId);

        //then
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
        Assertions.assertThat(findUser.getEmail()).isEqualTo(user.getEmail());
    }
}