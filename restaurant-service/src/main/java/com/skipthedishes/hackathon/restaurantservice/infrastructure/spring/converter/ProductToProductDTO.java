/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.restaurantservice.infrastructure.spring.converter;

import com.skipthedishes.hackathon.restaurantservice.application.dto.ProductDTO;
import com.skipthedishes.hackathon.restaurantservice.domain.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author lucas
 */
@Component
public class ProductToProductDTO extends ConverterDepedentConverter implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(Product source) {
        ProductDTO target = new ProductDTO();
        BeanUtils.copyProperties(source, target);
        target.setId(source.getId().toString());
        return target;
    }
    
}
