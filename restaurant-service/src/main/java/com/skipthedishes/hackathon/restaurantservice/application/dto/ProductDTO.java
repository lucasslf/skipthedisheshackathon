/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.restaurantservice.application.dto;

import java.math.BigDecimal;

/**
 *
 * @author lucas
 */
public class ProductDTO {

    private String id;
    private String description;
    private String title;
    private BigDecimal price;

    public ProductDTO() {
    }

    
    public ProductDTO(String id, String description, String title, BigDecimal price) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
