package com.eql.security;


import com.eql.model.User;
import com.eql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user !=null){
            return new  org.springframework.security.core.userdetails
                    .User(user.getEmail(),user.getPassword(),user.getRoles()
                    .stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList()));
        }else{
            throw new UsernameNotFoundException("invalid password");
        }


    }
}
