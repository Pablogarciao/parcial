package com.example.parcial.SERVICES.INTERFACES;


import com.example.parcial.MODELENTITY.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario save(Usuario usuario);
    public Usuario findById(Long id);
    public void deleteById(Long id);
}
