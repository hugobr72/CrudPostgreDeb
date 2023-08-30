package com.example.crudpostgredeb.services;

import com.example.crudpostgredeb.models.Produtos;
import com.example.crudpostgredeb.models.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public List<Produtos> GetAllProdutos() {
        return repository.findAll();
    }

    public Produtos GetProdutosById(int id) {
        try {
            return repository.findById(id).get();
        }catch (Exception e) {
            return null;
        }

    }

    public String CreateProdutos(Produtos produtos) {
        try {
            if (produtos.nome == null){
                return "O Produto precisa de um nome";
            }

            if (produtos.funcionario_responsavel_id == 0){
                return "O Produto precisa de um funcionario responsavel!";
            }
            var res = repository.save(produtos);
            return res.produto_id != 0 ? "Produto cadastrado com sucesso" : "Ocorreu um ao cadastrar produtos";
        }catch (Exception e) {
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }

    public String DeleteProduct(int id) {
        try{
            if(GetProdutosById(id) == null){
                return "Produto não encontrado!";
            }
            repository.deleteById(id);
            return "Produto deletado com sucesso!";
        }catch (Exception e){
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }
    @Transactional
    public String UpdateProdutos(Produtos produtos) {
        try {
            if(GetProdutosById(produtos.produto_id) == null){
                return "Produto não encontrado!";
            }
            if(produtos.funcionario_responsavel_id == 0){
                return "O Produto precisa de um funcionario responsavel!";
            }

            if(produtos.nome == null){
                return "O Produto precisa de um nome";
            }

            if(produtos.descricao == null){
                return "O Produto precisa de uma descrição";
            }

            repository.updateProduto(produtos.produto_id, produtos.nome, produtos.descricao, produtos.funcionario_responsavel_id);
            return "Produto atualizado com sucesso!";
        }catch (Exception e) {
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }
}
