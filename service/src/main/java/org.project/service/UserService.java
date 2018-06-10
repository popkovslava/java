package org.project.service;

import org.project.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    UsersRepository users();
    // UserDetails loadUserByUsername(String name);
}
