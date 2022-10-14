package com.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oderId;
    private Long pid;
    private String userId;

    public OrderDetails() {
        super();
    }

    public OrderDetails(Long pid, String userId) {
        this.pid = pid;
        this.userId = userId;
    }
}
