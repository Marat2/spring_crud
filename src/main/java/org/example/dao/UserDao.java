package org.example.dao;

import org.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(Long id,User user);
    void delete(Long id);
    List<User> listUsers();
    User userById(Long id);
    User loadUserByUsername(String s);
}
