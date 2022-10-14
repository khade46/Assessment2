package com.order.controller;

import com.order.model.Product;
import com.order.repository.ProductRepo;
import com.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/items")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProducts(){
        productService.addProducts();
        return ResponseEntity.ok(productRepo.findAll());
    }
    @GetMapping("/get/{category}")
    public ResponseEntity<List<Product>>getByCategory(@PathVariable String category){
        return ResponseEntity.ok(productRepo.findByCategory(category));
    }
}
