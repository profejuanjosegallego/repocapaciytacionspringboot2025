package com.example.ProyectoSpringboot.repositorios;

import com.example.ProyectoSpringboot.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {
}
