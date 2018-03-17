/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.dto;

import java.util.List;

/**
 *
 * @author lucas
 */
public class OrderDTO {
    private String user;
    private List<ProductDTO> products;

    public OrderDTO() {
    }
    
    

    public OrderDTO(String user, List<ProductDTO> products) {
        this.user = user;
        this.products = products;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }


    
    
}
