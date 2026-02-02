package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", indexes = {
        @Index(name="idx_product_price", columnList = "price"),
        @Index(name="idx_product_location", columnList = "location"),
        @Index(name="idx_product_created_at", columnList = "created_at")
})
public class Product {


    @Id
    @Column(name="product_id")
    private String productId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="location")
    private String location;

    @Column(name="price")
    private double price;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name="attributes", columnDefinition = "json")
    private Map<String, Object> attributes;

    @Column(name="status")
    private int status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="sell_user_id")
    private User sellUser;

    @ManyToOne
    @JoinColumn(name="buy_user_id")
    private User buyUser;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();





}
