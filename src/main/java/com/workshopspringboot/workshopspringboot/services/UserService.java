package com.workshopspringboot.workshopspringboot.services;

import com.workshopspringboot.workshopspringboot.core.exceptions.ResourceNotFoundException;
import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import com.workshopspringboot.workshopspringboot.repositories.OrderRepository;
import com.workshopspringboot.workshopspringboot.repositories.UserRepository;
import com.workshopspringboot.workshopspringboot.domain.entities.User;
import com.workshopspringboot.workshopspringboot.domain.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    public Page<User> findAll(Specification<User> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Page<Order> findAllOrders(Long id, Specification<Order> inputSpec, Pageable pageable) {
        var spec = Specification.where(inputSpec).and((root, query, builder) -> builder.equal(root.get("client"), id));
        return orderRepository.findAll(spec, pageable);
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

    public User update(Long id, User userInput) {
        try {
            var user = repository.findById(id).get();
            updateData(user, userInput);
            return repository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(User user, User userInput) {
        user.replaceName(userInput.getName());
        user.replacePhone(userInput.getPhone());
    }
}
