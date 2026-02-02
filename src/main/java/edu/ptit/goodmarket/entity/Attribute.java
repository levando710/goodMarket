package edu.ptit.goodmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="attribute")
public class Attribute {

    @Id
    @Column(name="attribute_id")
    private String attributeId;

    @Column(name="attribute_name")
    private String attributeName;

    @Column(name="attribute_type")
    private String attributeType;

    @Column(name="options") // trong trường hợp type của thuộc tính là select
    private String options;

    @ManyToOne
    @Column(name="category_id")
    private Category category;
}
