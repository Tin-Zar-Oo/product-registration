package com.example.studentregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerOrderIdNew;
    private int productIdNew;
    private int quantity;
    @ManyToOne
    private CustomerOrder customerOrder;
    @ManyToOne
    private Product product;

    public OrderedProduct(int customerOrderIdNew, int productIdNew, int quantity) {
        this.customerOrderIdNew = customerOrderIdNew;
        this.productIdNew = productIdNew;
        this.quantity = quantity;
    }
}
