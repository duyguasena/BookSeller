package com.example.BookSeller.security;

import com.example.BookSeller.model.User;
import com.example.BookSeller.service.IUserService;
import com.example.BookSeller.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=userService.findByUsername(userName)
                .orElseThrow(()->new UsernameNotFoundException(userName));

        Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .userName(userName)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
