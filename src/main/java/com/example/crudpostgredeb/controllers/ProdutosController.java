package com.example.crudpostgredeb.controllers;

import com.example.crudpostgredeb.models.Produtos;
import com.example.crudpostgredeb.services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    public ProdutosService service;

    @GetMapping("/")
    public ResponseEntity<?> GetAllProdutos(){

        var result = service.GetAllProdutos();
        if(result != null){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body("Ocorreu um erro, tente novamente mais tarde!");
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateProduto(@RequestBody Produtos produto){

        var result = service.CreateProdutos(produto);
        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteProduto(@PathVariable int id){
        var result = service.DeleteProduct(id);
        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateProduto(@RequestBody Produtos produto, @PathVariable int id){
        produto.produto_id = id;
        var result = service.UpdateProdutos(produto);
        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
