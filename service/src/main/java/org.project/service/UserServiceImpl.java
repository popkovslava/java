package org.project.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.project.entity.Users;
//import org.project.repository.RoleRepository;
import org.project.repository.UserRepository;
import org.project.repository.custom.UsersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private  final  UserRepository userRepository;

    @Autowired
    UserServiceImpl( UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserRepository users() {
        return userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       return Optional.of(name).
                map(userRepository::findByUsername)
               .map(userRepository::userDetailsConverter)
               .orElseThrow(()->new UsernameNotFoundException("User dos,not  exsist"));
      }

      public Users registerSave(Users user) {
            return userRepository.save(user);
      }
}
