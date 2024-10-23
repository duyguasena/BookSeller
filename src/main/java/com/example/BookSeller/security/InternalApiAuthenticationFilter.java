package com.example.BookSeller.security;

import com.example.BookSeller.util.SecurityUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Slf4j
public class InternalApiAuthenticationFilter extends OncePerRequestFilter {
    private final String accesKey;

    public InternalApiAuthenticationFilter(String accesKey) {
        this.accesKey = accesKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try
        {
            String requestKey= SecurityUtils.extractAuthTokenFromRequest(request);

            if (requestKey==null|| !requestKey.equals(accesKey))
            {
                log.warn("Internal key endpoint requested without /wrong key uri:{}",request.getRequestURI());
                throw  new RuntimeException("UNAUTHORIZED");
            }
            UserPrincipal user=UserPrincipal.createSuperUser();
            UsernamePasswordAuthenticationToken authenticationToken=
                    new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        catch (Exception ex){
            log.error("Could not set user authentication in security context",ex);
        }
        filterChain.doFilter(request,response);


    }
}
