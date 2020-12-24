package org.example.service;

import org.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(Long id,User user);
    void delete(Long id);
    List<User> listUsers();
    User userById(Long id);
    UserDetails loadUserByUsername(String s);
}
