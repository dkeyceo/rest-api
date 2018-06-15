package com.dkey.rest.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name="message_mapping")
public class MessageMapping implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @JoinColumn(name="to_id")
//    @Column(name = "to_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User toId;
    @NotNull
    @JoinColumn(name="from_id")
//    @Column(name = "from_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User fromId;

    @NotNull
    @JoinColumn(name="message_id")
//    @Column(name = "message_id")
    @ManyToOne(targetEntity = Message.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Message messageId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getToId() {
        return toId;
    }

    public void setToId(User toId) {
        this.toId = toId;
    }

    public User getFromId() {
        return fromId;
    }

    public void setFromId(User fromId) {
        this.fromId = fromId;
    }

    public Message getMessageId() {
        return messageId;
    }

    public void setMessageId(Message messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMapping that = (MessageMapping) o;
        return id == that.id &&
                Objects.equals(toId, that.toId) &&
                Objects.equals(fromId, that.fromId) &&
                Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, toId, fromId, messageId);
    }

    @Override
    public String toString() {
        return "MessageMapping{" +
                "id=" + id +
                ", toId=" + toId +
                ", fromId=" + fromId +
                ", messageId=" + messageId +
                '}';
    }
}

