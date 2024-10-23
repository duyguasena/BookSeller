package com.example.BookSeller.service;

import com.example.BookSeller.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
