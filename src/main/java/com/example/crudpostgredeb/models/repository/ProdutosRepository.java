package com.example.crudpostgredeb.models.repository;

import com.example.crudpostgredeb.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

    @Modifying
    @Query("Update produtos as p set p.descricao = :descricao, p.nome = :nome, p.funcionario_responsavel_id = :funcionario_responsavel_id where p.produto_id = :id")
    public void updateProduto(int id, String nome, String descricao, int funcionario_responsavel_id);
}
