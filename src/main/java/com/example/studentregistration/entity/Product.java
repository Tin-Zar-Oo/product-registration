package com.example.studentregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private Date lastUpdated;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    public void addOrderedProduct(OrderedProduct orderedProduct){
        orderedProduct.setProduct(this);
        orderedProducts.add(orderedProduct);
    }

    public Product(String name, double price, String description, Date lastUpdated) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }
}
