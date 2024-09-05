package com.sheryians.major.service.impl;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import com.sheryians.major.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void removeCategoryById(int id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
       return this.categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> updatesCategoryById(int id) {
        return this.categoryRepository.findById(id);
    }
}
