package org.example.service;

import org.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(Integer id,User user);
    void delete(Integer id);
    List<User> listUsers();
    User userById(Integer id);
    UserDetails loadUserByUsername(String s);
    User getByName(String s);
}
