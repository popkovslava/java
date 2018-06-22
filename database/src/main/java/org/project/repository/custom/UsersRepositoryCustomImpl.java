package org.project.repository.custom;

import org.project.entity.Role;
import org.project.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class UsersRepositoryCustomImpl implements  UsersRepositoryCustom {

//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UsersRepositoryCustomImpl(PasswordEncoder passwordEncoder){
//         this.passwordEncoder=passwordEncoder;
//    }

    @Override
    public UserDetails userDetailsConverter(Users user) {

//                return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(user.getUsername())
//                .password(String.format("{noop}%s",user.getPassword()))
//                .authorities(
//                        user.getRole().name()
//
//
//                )
//                .build();

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getUsername())
                .password(String.format("{noop}%s",user.getPassword()))
//                .authorities(user.getRole()
//                        .map(Role::name)
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList())
//                )
                .build();


//        return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(user.getUsername())
//                .password(String.format("{noop}%s",user.getPassword()))
//                .authorities(user
//                        .getRoles()
//
//                        .map(Role::getName)
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList())
//                )
//                .build();
    }



//    public Users userRegister(Users user) {
////        String encryptedPassword =
////                passwordEncoder.encode(user.getPassword());
//        user.setPassword(user.getPassword());
//        user.setUsername(user.getUsername());
//       // user.setRoles()
//       return user;
//    }
}
