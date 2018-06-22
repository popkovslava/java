package org.project.service;

import org.project.entity.Users;
import org.project.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public interface UserService extends  UserDetailsService {
    UserRepository users();
    Users registerSave(Users user);
}
