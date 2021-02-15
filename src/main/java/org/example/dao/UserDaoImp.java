package org.example.dao;

import org.example.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Transactional
    public void update(Integer id, User user) {
        User getUser = userById(id);
        getUser.setUsername(user.getUsername());
        getUser.setLast_name(user.getLast_name());
        getUser.setEmail(user.getEmail());
        sessionFactory.getCurrentSession().update(getUser);
    }
    @Transactional
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().delete(userById(id));
    }
    @Transactional
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    @Transactional
    public User userById(Integer id) {
        return (User)sessionFactory.getCurrentSession().createQuery("from User as u where u.id =:id").
                setParameter("id" ,id).getSingleResult();
    }
    
    @Transactional
    @Override
    public User loadUserByUsername(String s) {
        return (User)sessionFactory.getCurrentSession().createQuery("from User as u where u.username =:name").
                setParameter("name" ,s).getSingleResult();
    }
}
