package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public void addCategory(Category category);

    public List<Category> getCategories();

    public void removeCategoryById(int id);

    Optional<Category> getCategoryById(int id);

    Optional<Category> updatesCategoryById(int id);


}
