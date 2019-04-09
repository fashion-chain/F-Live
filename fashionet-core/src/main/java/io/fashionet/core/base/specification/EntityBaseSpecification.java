package io.fashionet.core.base.specification;

import io.fashionet.core.base.model.TableBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class EntityBaseSpecification<T extends TableBase> {
    public abstract Specification<T> listFilter(T base);

    public abstract Specification<T> enabled();

    public Specification<T> filter(T base) {
        return Specifications.where(valid()).and(listFilter(base));
    }

    public Specification<T> valid() {
        return new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNull(root.get("deleteDate"));
            }
        };
    }
}
