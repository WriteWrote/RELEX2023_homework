package org.obukhova.ssr.model.entity;


import jakarta.persistence.*;

@jakarta.persistence.Entity
@Table(name = "messages", schema = "ssr2023_hometask")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
