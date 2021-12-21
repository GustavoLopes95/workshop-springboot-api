package com.workshopspringboot.workshopspringboot.data;


import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
