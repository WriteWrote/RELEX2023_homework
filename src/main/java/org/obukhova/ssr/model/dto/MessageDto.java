package org.obukhova.ssr.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
    @JsonProperty("sender_id")
    @NotNull
    private Integer senderId;
    @NotNull(message = "message text must not be null")
    private String text;
}
