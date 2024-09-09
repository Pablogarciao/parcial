package com.example.parcial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcial.MODELENTITY.User;
import java.util.List;

public interface IUserDAO extends  JpaRepository<User, Long>{
//    public List<User> findByName(String name);
//    public List<User> findByEmail(String email);
//    public List<User> findByPhone(String phone);
}

