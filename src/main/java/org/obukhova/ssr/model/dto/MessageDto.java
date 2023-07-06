package org.obukhova.ssr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
    private String sender;
    private String text;
}
