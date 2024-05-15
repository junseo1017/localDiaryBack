package com.locald.domain.user.dao;

import com.locald.domain.user.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepository {

    //  스프링부트가 주입해줌.
    @PersistenceContext
    private EntityManager em;

    public Long save(User user){
        em.persist(user);
        return user.getId();
    }

    public User find(Long id){
        return em.find(User.class,id);
    }

}
