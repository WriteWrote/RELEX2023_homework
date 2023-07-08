package org.obukhova.ssr.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterDto {
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 2, max = 100)
    private String password;
}
