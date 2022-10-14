package com.order.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Long pid;
    private String category;
    private String pname;
    private int price;

    public Product() {
        super();
    }

    public Product(Long pid, String category, String pname, int price) {
        this.pid = pid;
        this.category = category;
        this.pname = pname;
        this.price = price;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String type) {
        this.category = category;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
