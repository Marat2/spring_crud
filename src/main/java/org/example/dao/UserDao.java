package org.example.dao;

import org.example.domain.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    void add(User user);
    void update(Integer id,User user);
    void delete(Integer id);
    List<User> listUsers();
    User userById(Integer id);
    User loadUserByUsername(String s);
}
