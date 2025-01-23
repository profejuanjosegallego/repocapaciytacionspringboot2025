package com.example.ProyectoSpringboot.repositorios;

import com.example.ProyectoSpringboot.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido,Integer> {


}
