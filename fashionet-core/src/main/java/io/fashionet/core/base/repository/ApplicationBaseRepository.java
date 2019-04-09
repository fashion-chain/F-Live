package io.fashionet.core.base.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface ApplicationBaseRepository<T, ID extends Serializable>
        extends CrudRepository<T, ID> {
                //QueryDslPredicateExecutor<T>
}
