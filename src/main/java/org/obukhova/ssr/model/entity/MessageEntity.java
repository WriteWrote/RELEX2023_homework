package org.obukhova.ssr.model.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "messages", schema = "ssr2023_hometask")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "text")
    private String text;

    public MessageEntity(Integer id, Integer senderId, String text) {
        this.id = id;
        this.senderId = senderId;
        this.text = text;
    }

    public MessageEntity() {
    }
}
