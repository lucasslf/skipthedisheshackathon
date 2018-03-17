package com.skipthedishes.hackathon.restaurantservice;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestaurantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    /**
     *
     * @param converters
     * @param genericConverters
     * @return
     */
    @Bean("dtoConversionService")
    public ConversionService conversionService(@Autowired Set<Converter> converters) {
        GenericConversionService conversionService = new DefaultConversionService();
        ConversionServiceFactory.registerConverters(converters, conversionService);
        return conversionService;
    }
}
