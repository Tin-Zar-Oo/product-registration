package com.example.studentregistration.dao;

import com.example.studentregistration.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder,Integer> {
}
