package org.obukhova.ssr.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Table(name = "messages", schema = "ssr2023_hometask")
@Getter
@Setter
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "text")
    private String text;

    public MessageEntity(Integer id, String sender, String text) {
        this.id = id;
        this.sender = sender;
        this.text = text;
    }

    public MessageEntity() {

    }
}
