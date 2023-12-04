package com.example.crudpostgredeb.controllers;

import com.example.crudpostgredeb.models.Funcionarios;
import com.example.crudpostgredeb.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/")
    public ResponseEntity<?>  GetAllFuncionarios(){
        var result = service.GetAll();
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateFuncionarios(@RequestBody Funcionarios funcionario){
        var result = service.CreateFuncionario(funcionario);

        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateFuncionarios(@PathVariable int id, @RequestBody Funcionarios funcionario){
        funcionario.funcionario_id = id;
        var result = service.UpdateFuncionario(funcionario);
        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteFuncionarios(@PathVariable int id){
        var result = service.DeleteFuncionario(id);

        if(result.contains("sucesso")){
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

}
