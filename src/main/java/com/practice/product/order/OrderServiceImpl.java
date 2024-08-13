package com.practice.product.order;

import com.practice.product.discount.DiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder() {

        int discount = discountPolicy.discount("VIP", 20000);
        return new Order("ItemA", 20000, discount);
    }
}
