package com.example.demo.servicos;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.ProdutoDTO;
import com.example.demo.entidades.Produto;
import com.example.demo.repositorio.ProdutoRepositorioJPA;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorioJPA produtoRepositorioJPA;
	
	public ProdutoDTO insert(ProdutoDTO produto) {
		Produto prod = new Produto(produto);
		return new ProdutoDTO(produtoRepositorioJPA.save(prod));
	}
	
	public List<ProdutoDTO> findAll() {
		List<Produto> list = produtoRepositorioJPA.findAll();
		return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		
	}
	
	public Optional<ProdutoDTO> findById(Integer id) {
		return Optional.of(new ProdutoDTO(produtoRepositorioJPA.findById(id).get()));
	}
	
	public void delete(Integer id) {
		produtoRepositorioJPA.deleteById(id);
	}
	
	public Optional<ProdutoDTO> findByIdPrecoJpql(Integer id, Double preco) {
		return Optional.of(new ProdutoDTO(produtoRepositorioJPA.findProdutoParam(id, preco).get()));
		
	}

	public Optional<ProdutoDTO> findByIdPrecoSql(Integer id, Double preco) {
		return Optional.of(new ProdutoDTO(produtoRepositorioJPA.findProdutoParamSql(id, preco).get()));
		
	}

	public Optional<ProdutoDTO> findByNomeJpql(String nome){
		return Optional.of(new ProdutoDTO(produtoRepositorioJPA.findByNomeJpql(nome).get()));
	}

	public Optional<ProdutoDTO> findByNomeSql(String nome){
		return Optional.of(new ProdutoDTO(produtoRepositorioJPA.findByNomeSql(nome).get()));
	}
}
