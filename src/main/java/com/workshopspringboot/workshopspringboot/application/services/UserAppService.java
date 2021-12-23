package com.workshopspringboot.workshopspringboot.application.services;

import com.workshopspringboot.workshopspringboot.core.exceptions.ResourceNotFoundException;
import com.workshopspringboot.workshopspringboot.data.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import com.workshopspringboot.workshopspringboot.domain.exceptions.DomainException;
import com.workshopspringboot.workshopspringboot.domain.services.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserAppService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserDomainService userDomainService;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DomainException("Cannot remove a user with order associated");
        }
    }

    public User update(Long id, User user) {
        try {
            return userDomainService.updateInfo(id, user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
