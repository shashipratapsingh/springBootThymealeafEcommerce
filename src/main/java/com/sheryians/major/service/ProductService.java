package com.sheryians.major.service;

import com.sheryians.major.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void saveProduct(Product product);

    public void removeProductById(Long id);

    public Optional<Product> findById(Long id);

    public List<Product> getAllProductByCategoryId(Long id);

    public List<Product> getProducts();
}
