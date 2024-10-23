package com.example.BookSeller.controller;


import com.example.BookSeller.model.User;
import com.example.BookSeller.service.IAuthenticationService;
import com.example.BookSeller.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;
    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")//kullanıcı kaydetme yöntemi
    public ResponseEntity<?> signUp(@RequestBody User user){
        if(userService.findByUsername(user.getUserName()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PostMapping("sign-in")//kullanıcı oturum açma işlemi
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user),HttpStatus.OK);

    }



}
