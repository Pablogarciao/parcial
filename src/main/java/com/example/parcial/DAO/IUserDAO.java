package com.example.parcial.DAO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcial.MODELENTITY.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.naming.Name;
import java.util.List;

public interface IUserDAO extends  JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.id_user = :id")
    List<User> findById_user(Id id);

    @Query("SELECT u FROM User u WHERE u.rol = :rol")
    List<User> findByRol(@Param("rol") String rol);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(Email email);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);
}

