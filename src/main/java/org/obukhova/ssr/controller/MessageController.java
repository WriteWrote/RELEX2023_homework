package org.obukhova.ssr.controller;

import org.obukhova.ssr.model.dto.MessageDto;
import org.obukhova.ssr.model.entity.MessageEntity;
import org.obukhova.ssr.service.MessageReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageReceiverService service;

    @Autowired
    public MessageController(MessageReceiverService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto dto) {
        try {
            return ResponseEntity
                    .ok()
                    .header("Server message", "Message sent successfully")
                    .body(service.createMessage(dto));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError()
                    .header("Server message", "User message saving failed")
                    .build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MessageDto>> getAllMessages() {
        return ResponseEntity.ok()
                .header("Server message", "Request all messages succeeded")
                .body(service.getAllMessages());
    }
}
