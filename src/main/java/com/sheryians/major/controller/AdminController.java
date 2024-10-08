package com.sheryians.major.controller;

import com.sheryians.major.dto.ProductDTO;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";

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

    //Deleting the categories
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
       categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    //update category by id
    @GetMapping("/admin/categories/update/{id}")
    public String  updateCategoryById(@PathVariable int id, Model model){
        Optional<Category> category=this.categoryService.getCategoryById(id);
        if (category.isPresent()){
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }else {
            return "404";
        }

    }

    //products

    @Autowired
    private ProductService productService;

    @GetMapping("/admin/products")
    public String getProduct(Model model){
        model.addAttribute("products",productService.getProducts());
        return "products";
    }

    @GetMapping("admin/products/add")
    public String postProduct(Model model){
        model.addAttribute("productDTO" ,new ProductDTO());
        model.addAttribute("categories",categoryService.getCategories());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String saveProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
                              @RequestParam("productImage") MultipartFile file,
                              @RequestParam("imgName") String imgName) throws IOException{

        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.updatesCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID= file.getOriginalFilename();
            Path fileNameAndPath= Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }else {
            imageUUID=imgName;
        }

        product.setImageName(productDTO.getImageName());
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

}
