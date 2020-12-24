package org.example.service;

import org.example.dao.UserDao;
import org.example.domain.Role;
import org.example.domain.User;
import org.example.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional
    public void update(Long id, User user) {
        userDao.update(id,user);
    }
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    public List<User> listUsers() {
        return userDao.listUsers();
    }



    public User userById(Long id) {
        return userDao.userById(id);
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(s);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role:user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        //System.out.println("1user : "+ user.toString());
        return SecurityUser.fromUser(user);
    }
}
