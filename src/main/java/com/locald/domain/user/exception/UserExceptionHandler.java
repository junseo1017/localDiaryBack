package com.locald.domain.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class UserExceptionHandler {

    // Method Valid Failed 400
    // User Not Found 400
    @ExceptionHandler({MethodArgumentNotValidException.class,UserException.class})
    public ResponseEntity<UserSigninErrorResult> signInErrorHandler() {
        log.error("signInErrorHandler Execute");
        UserSigninErrorResult userErrorResult = new UserSigninErrorResult("入力形式が間違っています。ID又はパスワードを確認してください。");
        return new ResponseEntity<>(userErrorResult,HttpStatus.BAD_REQUEST);
    }

    // Runtime Exception 500
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<UserSigninErrorResult> runtimeErrorHandler(RuntimeException rEx) {
        log.error("RuntimeException={}",rEx);
        UserSigninErrorResult userErrorResult = new UserSigninErrorResult("サーバーとの接続が不安定です。しばらくしてから再度お試しください。");
        return new ResponseEntity<>(userErrorResult,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
