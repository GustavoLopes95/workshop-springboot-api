package com.workshopspringboot.workshopspringboot.config;

import com.workshopspringboot.workshopspringboot.data.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
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

    @Override
    public void run(String... args) throws Exception {
        var u1 = new User(null, "Test one", "testOne@test.com",  "999999991", "123456");
        var u2 = new User(null, "Test Two", "testTwo@test.com",  "999999992", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
