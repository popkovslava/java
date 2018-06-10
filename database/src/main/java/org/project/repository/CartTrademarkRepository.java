package org.project.repository;

import org.project.entity.CartTrademark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartTrademarkRepository extends CrudRepository<CartTrademark, Long> {
}