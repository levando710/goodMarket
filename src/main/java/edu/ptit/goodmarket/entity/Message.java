package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="message")
public class Message {

    @Id
    @Column(name="message_id")
    private String messageId;

    @Column(name="message_text")
    private String messageText;

    @Column(name="is_read")
    private int isRead;

    @CreationTimestamp
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User sendUser;
}
