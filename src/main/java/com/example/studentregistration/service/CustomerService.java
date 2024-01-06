package com.example.studentregistration.service;

import com.example.studentregistration.dao.CategoryDao;
import com.example.studentregistration.dao.CustomerDao;
import com.example.studentregistration.dao.CustomerOrderDao;
import com.example.studentregistration.dao.ProductDao;
import com.example.studentregistration.entity.Category;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CategoryDao categoryDao;
    private final CustomerDao customerDao;
    private final ProductDao productDao;
    private final CustomerOrderDao customerOrderDao;

    public List<Category> ListAllCategories(){
          return categoryDao.findAll();
    }
    @Transactional
    public void createCategory(Category category){
        categoryDao.save(category);
    }

    public void deleteCategory(int id){
        if(categoryDao.existsById(id)){
            categoryDao.deleteById(id);
        } else throw new EntityNotFoundException( id + "Not found!");
    }

    public Category findCategoryById(int id){
        return categoryDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void updateCategory(int id, Category category) {
        category.setId(id);
       categoryDao.save(category);
    }





}
