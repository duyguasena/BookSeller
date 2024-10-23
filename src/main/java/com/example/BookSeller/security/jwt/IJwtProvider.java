package com.example.BookSeller.security.jwt;

import com.example.BookSeller.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface IJwtProvider {
    String generateToken(UserPrincipal auth);

    UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
