package com.example.BookSeller.service;

import com.example.BookSeller.model.Role;
import com.example.BookSeller.model.User;
import com.example.BookSeller.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setUserName(user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }
    @Override
    public Optional<User> findByUsername(String userName){
        return userRepository.findByUsername(userName);
    }
    @Override
    @Transactional
    public void makeAdmin(String username){
        userRepository.updateUserRole(username,Role.ADMIN);
    }
}
