package org.project.repository;

import org.project.entity.UserTrademark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTrademarkRepository extends CrudRepository<UserTrademark, Long> {
}
