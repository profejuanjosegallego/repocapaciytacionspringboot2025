package com.example.ProyectoSpringboot.repositorios;

import com.example.ProyectoSpringboot.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {

    List<Usuario> findByNombres(String nombresUsario);

}
