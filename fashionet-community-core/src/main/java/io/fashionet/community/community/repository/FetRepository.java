package io.fashionet.community.community.repository;

import io.fashionet.core.base.repository.EntityBaseRepository;
import io.fashionet.community.community.model.Fet;
import org.springframework.stereotype.Repository;

@Repository
public interface FetRepository extends EntityBaseRepository<Fet, Long> {
}
