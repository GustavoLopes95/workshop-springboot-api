package com.workshopspringboot.workshopspringboot.application.Specifications;

import com.workshopspringboot.workshopspringboot.domain.entities.Order;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class OrderSpecs  {

    public static Specification<Order> eqStatus(Integer status) {
        return (Root <Order> root, CriteriaQuery <?>query, CriteriaBuilder builder) -> {
                if(Objects.isNull(status)) return builder.isTrue(builder.literal(true));
                return builder.equal(root.get("status"), status);
            };
    }

    public static Specification<Order> eqClientId(Long id) {
        return (Root <Order> root, CriteriaQuery <?>query, CriteriaBuilder builder) -> {
            if(Objects.isNull(id)) return builder.isTrue(builder.literal(true));
            return builder.equal(root.get("client"), id);
        };
    }
}
