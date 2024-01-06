package com.example.studentregistration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String cityRegion;
    private String customerNumber;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrder.setCustomer(this);
        customerOrders.add(customerOrder);
    }

    public Customer(String name, String email, String phoneNumber, String address, String cityRegion, String customerNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cityRegion = cityRegion;
        this.customerNumber = customerNumber;
    }
}
