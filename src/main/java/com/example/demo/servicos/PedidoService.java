package com.example.demo.servicos;

import java.util.List;

import com.example.demo.entidades.Pedido;
import com.example.demo.repositorio.PedidoRepositorioJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepositorioJpa repositorioJpa;

    public Pedido insert(Pedido pedido) {
        return repositorioJpa.save(pedido);
    }

    public List<Pedido> findAll() {
        return repositorioJpa.findAll();
    }
}
