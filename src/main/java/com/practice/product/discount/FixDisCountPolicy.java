package com.practice.product.discount;

public class FixDisCountPolicy implements DiscountPolicy{


    @Override
    public int discount(String grade, int itemPrice) {
        if("VIP".equals(grade)){
            return 1000;
        }else {
            return 0;
        }
    }


}
