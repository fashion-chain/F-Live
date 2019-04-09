package io.fashionet.core.base.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface EntityBaseRepository<T, ID extends Serializable>
        extends ApplicationBaseRepository<T, ID>, JpaSpecificationExecutor<T> {
    List<T> findAll();
}
