package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="review", indexes = {
        @Index(name = "idx_review_rate", columnList = "rate") // lọc đánh giá
})
public class Review {

    @Id
    @Column(name="review_id")
    private String reviewId;

    @Column(name="rate")
    private double rate;

    @Column(name="comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name= "rater_id")
    private User rateUser;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
