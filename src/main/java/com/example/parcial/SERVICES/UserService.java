package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IUserDAO;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User save(User user) {return userDAO.save(user); }

    @Override
    public User findById(Long id) {return userDAO.findById(id).orElse(null); }

    @Override
    public void deleteById(Long id) {userDAO.deleteById(id); }
}