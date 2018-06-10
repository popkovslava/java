package org.project.repository;

import org.project.entity.Trademark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrademarkRepository extends CrudRepository<Trademark, Long> {
}
