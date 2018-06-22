package org.project.repository.custom;

import org.project.entity.Users;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositoryCustom {

    UserDetails userDetailsConverter(Users user);

}
