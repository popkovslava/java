package org.project.service;

import java.util.Optional;
import org.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersRepository users() {
        return usersRepository;
    }

//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return Optional.of(name)
//                .map(usersRepository::findByName)
//                .map(detailsConverter::convert)
//                .orElseThrow(() -> new UsernameNotFoundException("User does not exist!"));
//    }
}
