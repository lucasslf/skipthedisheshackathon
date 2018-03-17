/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.restaurantservice.domain.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Restaurant {

    @Id
    private UUID id;
    @Column
    private String name;
    @OneToMany(mappedBy = "restaurant")
    private List<Product> menu;

    public Restaurant() {
    }

    public Restaurant(UUID id) {
        this.id = id;
    }

    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getMenu() {
        return menu;
    }

    public void setMenu(List<Product> menu) {
        this.menu = menu;
    }

}
