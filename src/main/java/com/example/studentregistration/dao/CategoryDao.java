package com.example.studentregistration.dao;

import com.example.studentregistration.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
