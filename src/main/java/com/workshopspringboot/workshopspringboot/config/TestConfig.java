package com.workshopspringboot.workshopspringboot.config;

import com.workshopspringboot.workshopspringboot.data.CategoryRepository;
import com.workshopspringboot.workshopspringboot.data.OrderRepository;
import com.workshopspringboot.workshopspringboot.data.ProductRepository;
import com.workshopspringboot.workshopspringboot.data.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.Category;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.domain.entities.Product;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
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

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Test one", "testOne@test.com",  "999999991", "123456");
        var u2 = new User(null, "Test Two", "testTwo@test.com",  "999999992", "123456");

        var o1 = new Order(null, u1, OrderStatusEnum.PAID);
        var o2 = new Order(null, u1, OrderStatusEnum.WAITING_PAYMENT);
        var o3 = new Order(null, u2, OrderStatusEnum.CANCELED);
        var o4 = new Order(null, u2, OrderStatusEnum.DELIVERED);

        var c1 = new Category(null, "Electronics");
        var c2 = new Category(null, "Books");

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
        categoryRepository.saveAll(Arrays.asList(c1,c2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4 ,p5));
    }
}
