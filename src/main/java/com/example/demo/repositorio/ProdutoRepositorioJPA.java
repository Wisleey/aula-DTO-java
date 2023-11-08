package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.example.demo.entidades.Produto;

public interface ProdutoRepositorioJPA extends JpaRepository<Produto, Integer> {

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.preco <= :preco")
    Optional<Produto> findProdutoParam(Integer id, Double preco);

    @Query(value="SELECT p FROM Produto p WHERE p.id = :id AND p.preco <= :preco", nativeQuery = true)
    Optional<Produto> findProdutoParamSql(Integer id, Double preco);

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    Optional<Produto> findByNomeJpql(String nome);

    @Query(value = "SELECT p FROM tb_produto p WHERE p.nome like %:nome%", nativeQuery = true)
    Optional<Produto> findByNomeSql(String nome);
}
