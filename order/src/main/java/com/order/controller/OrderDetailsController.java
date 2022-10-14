package com.order.controller;

import com.order.model.OrderDetails;
import com.order.repository.OrderRepo;
import com.order.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/{pid}/{userId}")
    public String placeOrder(@PathVariable Long pid, @PathVariable String userId){
        String productName = productRepo.findById(pid).get().getPname();
        int productPrice = productRepo.findById(pid).get().getPrice();
        String username = restTemplate.getForObject("http://user-service/user/" +userId,String.class);
        OrderDetails orderDetails = new OrderDetails(pid,userId);
        orderRepo.save(orderDetails);
        return "Thankyou " +username+ " for your order for " +productName+ " of Rupees " +productPrice;
    }
}
