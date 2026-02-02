package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="room", indexes = {
        @Index(name = "idx_room_created_at", columnList = "created_at")
})
public class Room {

    @Id
    @Column(name="room_id")
    private String roomId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="seller_id") // Đã sửa từ user_id -> seller_id
    private User sellUserChat;

    @ManyToOne
    @JoinColumn(name="buyer_id") // Đã sửa từ user_id -> buyer_id
    private User buyUserChat;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

}
