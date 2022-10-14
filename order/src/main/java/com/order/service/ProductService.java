package com.order.service;

import com.order.model.Product;
import com.order.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    List<Product> list = List.of(
            new Product(101L,"Furniture","Chair",400),
            new Product(102L,"Furniture","Table",1000),
            new Product(103L,"Furniture","Sofa",35000),
            new Product(104L,"Sports","Cricket Bat", 1000),
            new Product(105L,"Sports","FootBall", 800),
            new Product(106L,"Sports","Cycle", 17000),
            new Product(107L,"Electronics","Mobile", 40000),
            new Product(108L,"Electronics","Laptop", 980000),
            new Product(109L,"Electronics","Camera", 60000)

    );

    public void addProducts(){
        productRepo.saveAll(list);
    }
}
