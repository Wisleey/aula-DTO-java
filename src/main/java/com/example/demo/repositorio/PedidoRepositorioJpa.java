package com.example.demo.repositorio;

import com.example.demo.entidades.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorioJpa extends JpaRepository<Pedido, Integer>{
    
}
