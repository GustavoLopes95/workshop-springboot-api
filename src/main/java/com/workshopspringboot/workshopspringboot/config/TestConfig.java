package com.workshopspringboot.workshopspringboot.config;

import com.workshopspringboot.workshopspringboot.data.*;
import com.workshopspringboot.workshopspringboot.domain.entities.*;
import com.workshopspringboot.workshopspringboot.domain.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        var c1 = new Category(null, "Electronics");
        var c2 = new Category(null, "Books");
        var c3 = new Category(null, "Computers");

        var p1 = new Product(null, "Design Patterns", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(c1,c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4 ,p5));

        p1.addCategory(c2);
        p2.addCategory(c1);
        p2.addCategory(c3);
        p3.addCategory(c3);
        p3.addCategory(c1);
        p4.addCategory(c1);
        p5.addCategory(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4 ,p5));

        var u1 = new User(null, "Test one", "testOne@test.com",  "999999991", "123456");
        var u2 = new User(null, "Test Two", "testTwo@test.com",  "999999992", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        var o1 = new Order(null, u1, OrderStatusEnum.PAID);
        var o2 = new Order(null, u1, OrderStatusEnum.WAITING_PAYMENT);
        var o3 = new Order(null, u2, OrderStatusEnum.CANCELED);
        var o4 = new Order(null, u2, OrderStatusEnum.DELIVERED);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

        var oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        var oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        var oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        var oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        var pa1 = new Payment(null, o1);
        o1.pay(pa1);

        orderRepository.save(o1);
    }
}
