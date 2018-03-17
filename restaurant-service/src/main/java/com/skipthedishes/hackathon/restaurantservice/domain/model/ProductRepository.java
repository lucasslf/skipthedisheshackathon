/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.restaurantservice.domain.model;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lucas
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByRestaurant(Restaurant restaurant);
}
