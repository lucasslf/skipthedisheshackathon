/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author lucas
 */
public class ProductDTO {
    private UUID id;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(UUID id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
