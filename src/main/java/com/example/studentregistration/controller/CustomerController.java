package com.example.studentregistration.controller;

import com.example.studentregistration.entity.Category;
import com.example.studentregistration.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping({"/","/home"})
    public String welcome(Model model){
        model.addAttribute("categories", customerService.ListAllCategories());
        model.addAttribute("category",new Category());
        return "index";
    }

    @PostMapping("save-category")
    public String saveCategory(Category category, BindingResult result){
        if(result.hasErrors()){
            return "index";
        }
        customerService.createCategory(category);
        return "redirect:/";
    }
    @GetMapping("/list-categories")
    public String ListAllCategories(Model model){
        model.addAttribute("categories",customerService.ListAllCategories());
        return "categories";
    }



    @GetMapping("/save-category")
    public String categories(Model model){
        model.addAttribute("category", new Category()); // creating command obj
        return "categories";
    }

    @GetMapping("/category/delete")
    public String deleteCategory(@RequestParam("id") int id){
        customerService.deleteCategory(id);
        return "redirect:/";
    }


    private int id;// to retrieve id
    @GetMapping("/category/update/{id}")
    public String updateCategory(@PathVariable int id, Model model ){
        model.addAttribute("category",customerService.findCategoryById(id));
        this.id = id;
        return "updateCategory";
    }

    @PostMapping("/update/category")
    public String updateSaveCategory( Category category, BindingResult result){
        if(result.hasErrors()){
            return "updateCategory";
        } customerService.updateCategory(id, category);
        return "redirect:/";
    }


}
