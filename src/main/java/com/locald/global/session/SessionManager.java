package com.locald.global.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response, String sessionKey){
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId,value);
        Cookie loginCookie = new Cookie(sessionKey,sessionId);
        response.addCookie(loginCookie);
    }


}
