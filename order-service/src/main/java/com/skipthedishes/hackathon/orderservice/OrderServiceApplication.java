package com.skipthedishes.hackathon.orderservice;

import com.skipthedishes.hackathon.orderservice.event.EventStore;
import com.skipthedishes.hackathon.orderservice.event.store.JpaEventStore;
import com.skipthedishes.hackathon.orderservice.projection.OrdersStatusProjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories
public class OrderServiceApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {

        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public EventStore createEventStore() {
        return new JpaEventStore(getOrdersStatusProjection());
    }

    @Bean
    public OrdersStatusProjection getOrdersStatusProjection() {
        return new OrdersStatusProjection();
    }
}
