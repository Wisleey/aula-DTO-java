package com.example.demo.controller;

import java.util.List;

import com.example.demo.entidades.Pedido;
import com.example.demo.servicos.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private PedidoService servico;

    @PostMapping
	public ResponseEntity<String> insert(@RequestBody Pedido pedido){
		Pedido prod = servico.insert(pedido);
		return prod !=  null ? new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED) : new ResponseEntity<>("Erro ao criar pedido", HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> list = servico.findAll();
		return !list.isEmpty() ?  new ResponseEntity<>(list, HttpStatus.OK) 
							   : new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
	}
}
