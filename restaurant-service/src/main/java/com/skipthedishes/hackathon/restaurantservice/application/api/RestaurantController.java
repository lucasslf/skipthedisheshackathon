/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.restaurantservice.application.api;

import com.skipthedishes.hackathon.restaurantservice.application.dto.ProductDTO;
import com.skipthedishes.hackathon.restaurantservice.application.dto.RestaurantDTO;
import com.skipthedishes.hackathon.restaurantservice.domain.model.Product;
import com.skipthedishes.hackathon.restaurantservice.domain.model.ProductRepository;
import com.skipthedishes.hackathon.restaurantservice.domain.model.Restaurant;
import com.skipthedishes.hackathon.restaurantservice.domain.model.RestaurantRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    @Qualifier("dtoConversionService")
    private ConversionService converter;

    @RequestMapping(path = "restaurant")
    public List<RestaurantDTO> getRestaurants() {
        List<Restaurant> source = restaurantRepository.findAll();
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Restaurant.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RestaurantDTO.class));
        List<RestaurantDTO> target = (List<RestaurantDTO>) converter.convert(source, sourceType, targetType);
        return target;

    }
    @RequestMapping(path = "restaurant/{id}/menu")
    public List<ProductDTO> getProducts(@PathVariable String id) {
        List<Product> products = productRepository.findByRestaurant(new Restaurant(UUID.fromString(id)));
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Product.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ProductDTO.class));
        List<ProductDTO> target = (List<ProductDTO>) converter.convert(products, sourceType, targetType);
        return target;

    }

}
