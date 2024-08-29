package com.sheryians.major.controller;

import com.sheryians.major.model.Category;
import com.sheryians.major.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCetegories(Model model){
        model.addAttribute("categories",categoryService.getCategories());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCetegoriesAdd(Model model){
        model.addAttribute("category" ,new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCetegoriesAdd(@ModelAttribute("category") Category category){
       this.categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
}
