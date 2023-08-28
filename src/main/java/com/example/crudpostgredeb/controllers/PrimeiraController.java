package com.example.crudpostgredeb.controllers;

import com.example.crudpostgredeb.models.MotorisaRepository;
import com.example.crudpostgredeb.models.Motorista;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class PrimeiraController {
    @Autowired
    private MotorisaRepository repository;

    @GetMapping("/")
    public List<Motorista> GetPrimary(){
        List<Motorista> result = repository.findAll();
        return  result;
    }

    @PostMapping("/")
    public ResponseEntity<String> PostInsert(@RequestBody Motorista motorista){

        if (motorista.nome == "" || motorista.nome == null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Voce precisa de um nome para criar o motorista");
        }
        Motorista result = repository.save(motorista);
        if (result.nome == motorista.nome){
            return ResponseEntity.status(HttpStatus.OK).body("Motorista criado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro, tente novamente mais tarde!");
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<?> PutUpdate(@PathVariable int id ,@RequestBody Motorista motorista) {
        try {
            var result = repository.findById(id);
            if (!result.isEmpty()) {
                Motorista motorista1 = result.get();
                int res = repository.updateMotorista(motorista.ativo, id);
                return ResponseEntity.status(HttpStatus.OK).body(motorista1);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Motorista não encontrado!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!" + e.getMessage() + " : ");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteMotorista(@PathVariable int id) {
        try{
            var result = repository.findById(id);
            if(!result.isEmpty()){
                repository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Motorista deletado com sucesso!");
            }
            return ResponseEntity.ok().body("Motorista não esta cadastrado!");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro!");
        }


    }

}
