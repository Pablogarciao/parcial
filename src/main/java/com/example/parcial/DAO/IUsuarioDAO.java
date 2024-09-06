package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioDAO extends  JpaRepository<Usuario, Long>{
//    public List<Usuario> findByName(String name);
//    public List<Usuario> findByAddress(String address);
//    public List<Usuario> findByEmail(String email);
//    public List<Usuario> findByPhone(String phone);
}
