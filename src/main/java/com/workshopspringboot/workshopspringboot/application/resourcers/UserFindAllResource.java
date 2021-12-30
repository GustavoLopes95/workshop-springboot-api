package com.workshopspringboot.workshopspringboot.application.resourcers;

import com.workshopspringboot.workshopspringboot.domain.entities.User;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "email", spec = Equal.class)
})
public interface UserFindAllResource extends Specification<User> {}
