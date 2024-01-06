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
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private Date dateCreated;
    private int confirmationNumber;
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    public void addOrderProduct(OrderedProduct orderedProduct){
        orderedProduct.setCustomerOrder(this);
        orderedProducts.add(orderedProduct);
    }

    public CustomerOrder(double amount, Date dateCreated, int confirmationNumber) {
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.confirmationNumber = confirmationNumber;
    }
}
