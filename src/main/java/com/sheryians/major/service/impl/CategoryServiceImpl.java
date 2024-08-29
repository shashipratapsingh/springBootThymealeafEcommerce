package com.sheryians.major.service.impl;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import com.sheryians.major.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void addCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }
}
