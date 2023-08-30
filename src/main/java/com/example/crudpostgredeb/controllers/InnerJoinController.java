package com.example.crudpostgredeb.controllers;

import com.example.crudpostgredeb.models.Funcionarios;
import com.example.crudpostgredeb.models.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class InnerJoinController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping("/")
    public ResponseEntity<?>  findAll(){
        try{
            return ResponseEntity.ok().body(repository.findAll());
        }catch (Exception e){
            return  ResponseEntity.internalServerError().body("Ocorreu um erro: " + e.getMessage());
        }


    }

}
