package com.locald.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserSigninForm {

    @NotBlank
    @Email
    private String email;
    @NotEmpty
    private String password;
}
