package org.obukhova.ssr.service;

import org.obukhova.ssr.model.dto.MessageDto;
import org.obukhova.ssr.model.entity.MessageEntity;
import org.obukhova.ssr.model.mapper.IMessageMapper;
import org.obukhova.ssr.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageReceiverService {
    private final Logger logger;
    private final MessageRepository repository;
    private final IMessageMapper mapper;

    @Autowired
    public MessageReceiverService(MessageRepository repository, IMessageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        logger = LoggerFactory.getLogger(MessageReceiverService.class);
    }

    public MessageDto createMessage(MessageDto dto) {
        MessageEntity entity = mapper.toEntity(dto);

        entity = repository.save(entity);

        logger.info("Recieved a message: id {}, sender {}, text {}",
                entity.getId().toString(), entity.getSenderId(), entity.getText());
        logger.info("Message with id {} saved successfully",
                entity.getId().toString());

        return Optional.of(mapper.fromEntity(entity))
                .orElseThrow();
    }

    public List<MessageDto> getAllMessages() {
        logger.info("Request to list all messages");
        return Optional.of(repository.findAll())
                .map(mapper::fromEntities)
                .orElse(new ArrayList<>());     // or else empty list
    }
}
