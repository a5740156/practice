package com.practice.product;

import com.practice.product.discount.DiscountPolicy;
import com.practice.product.discount.FixDisCountPolicy;
import com.practice.product.discount.RateDisCountPolicy;
import com.practice.product.order.OrderService;
import com.practice.product.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDisCountPolicy();
    }


}
