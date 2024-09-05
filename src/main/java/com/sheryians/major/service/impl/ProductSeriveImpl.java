package com.sheryians.major.service.impl;

import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSeriveImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
    @Override
    public void removeProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProductByCategoryId(Long id) {
        return productRepository.getAllProductByCategoryId(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


}
