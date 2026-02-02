package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="image")
public class Image {

    @Id
    @Column(name="image_id")
    private String imageId;

    @Column(name="image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
