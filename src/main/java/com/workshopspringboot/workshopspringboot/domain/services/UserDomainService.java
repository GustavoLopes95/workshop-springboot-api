package com.workshopspringboot.workshopspringboot.domain.services;

import com.workshopspringboot.workshopspringboot.data.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    @Autowired
    private UserRepository userRepository;

    public User updateInfo(Long id, User user) {
        var entity = userRepository.getOne(id);
        entity.replaceName(user.getName());
        entity.replacePhone(user.getPhone());
        return userRepository.save(entity);
    }
}
