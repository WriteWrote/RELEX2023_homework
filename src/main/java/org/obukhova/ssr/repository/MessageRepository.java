package org.obukhova.ssr.repository;

import org.obukhova.ssr.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Integer>,JpaRepository<MessageEntity, Integer> {
}
