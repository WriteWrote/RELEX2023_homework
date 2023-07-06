package org.obukhova.ssr.model.mapper;

import org.mapstruct.Mapper;
import org.obukhova.ssr.model.dto.MessageDto;
import org.obukhova.ssr.model.entity.MessageEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMessageMapper {
    MessageDto fromEntity(MessageEntity entity);

    MessageEntity toEntity(MessageDto dto);

    List<MessageDto> fromEntities(Iterable<MessageEntity> entities);
}
