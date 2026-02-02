package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", indexes = {
        @Index(name = "idx_user_email", columnList = "email", unique = true),
        @Index(name = "idx_user_username", columnList = "user_name", unique = true),
        @Index(name = "idx_user_phone", columnList = "phone_number")
})
public class User {
    @Id
    @Column(name ="user_id")
    private String userId;

    @Column(name ="user_name")
    private String userName;

    @Column(name = "name")
    private  String name;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;

    @Column(name="img_url")
    private String imgUrl;
    
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "rateUser",cascade = CascadeType.ALL)
    private List<Review> rateReviews = new ArrayList<>();

    @OneToMany(mappedBy = "sellUser",cascade = CascadeType.ALL)
    private List<Product> sellProducts = new ArrayList<>();

    @OneToMany(mappedBy = "buyUser",cascade = CascadeType.ALL)
    private List<Product> buyProducts = new ArrayList<>();

    @OneToMany(mappedBy = "buyUserChat",cascade = CascadeType.ALL)
    private List<Room> buyProductRooms = new ArrayList<>();

    @OneToMany(mappedBy = "sellUserChat",cascade = CascadeType.ALL)
    private List<Room> sellProductRooms = new ArrayList<>();

    @OneToMany(mappedBy = "sendUser",cascade = CascadeType.ALL)
    private List<Message> sentMessages = new ArrayList<>();

}
