package com.locald.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserSignupForm {

    private Long id;

    @NotBlank
    @Email
    private String email;

    private String name;

    @NotEmpty
    private String password;
}
