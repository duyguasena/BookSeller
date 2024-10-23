package com.example.BookSeller.service;

import com.example.BookSeller.model.User;
import com.example.BookSeller.security.UserPrincipal;
import com.example.BookSeller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }

}
