package com.practice.order;

import com.practice.product.AppConfig;
import com.practice.product.discount.DiscountPolicy;
import com.practice.product.order.Order;
import com.practice.product.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class OrderServiceTest {


    @Test
    public void order() {

//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Order order = orderService.createOrder();

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);

    }
}
