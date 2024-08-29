package com.sheryians.major.service;

import com.sheryians.major.model.Category;

import java.util.List;

public interface CategoryService {

    public void addCategory(Category category);

    public List<Category> getCategories();
}
