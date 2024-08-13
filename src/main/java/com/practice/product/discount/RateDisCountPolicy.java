package com.practice.product.discount;

public class RateDisCountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(String grade, int itemPrice) {

        if("VIP".equals(grade)) {
            return itemPrice * discountPercent /  100;
        }else {
            return 0;
        }
    }
}
