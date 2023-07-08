package org.obukhova.ssr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
    @NotEmpty(message = "sender must not be empty")
    private String sender;
    @NotNull(message = "message text must not be null")
    private String text;
}
