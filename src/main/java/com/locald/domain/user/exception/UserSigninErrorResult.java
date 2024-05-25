package com.locald.domain.user.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSigninErrorResult {
    private String message;
}
