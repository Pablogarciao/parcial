package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.Usuario;

import java.util.List;

public interface IUsuarioDAO extends  JpaRepository<Usuario, Long>{
    public List<Usuario> findByName(String name);
    public List<Usuario> findByAddress(String address);
    public List<Usuario> findByEmail(String email);
    public List<Usuario> findByPhone(String phone);
}
