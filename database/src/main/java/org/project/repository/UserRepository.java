package org.project.repository;

import org.project.entity.Users;
import org.project.repository.custom.UsersRepositoryCustom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>,UsersRepositoryCustom {
        Users findByUsername(String username);
}