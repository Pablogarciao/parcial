package com.example.parcial.SERVICES.INTERFACES;

import java.util.List;
import com.example.parcial.MODELENTITY.User;


public interface IUserService {
    public List<User> findAll();
    public User save(User user);
    public User findById(Long id);
    public void deleteById(Long id);
}
