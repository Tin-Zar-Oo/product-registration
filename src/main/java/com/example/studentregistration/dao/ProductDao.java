package com.example.studentregistration.dao;

import com.example.studentregistration.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
