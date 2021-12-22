package com.workshopspringboot.workshopspringboot.core.domainObjects;

import com.workshopspringboot.workshopspringboot.domain.entities.User;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@MappedSuperclass
public abstract class DomainEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;

    protected DomainEntity() {
    }

    protected DomainEntity(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainEntity entity = (DomainEntity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
