package com.example.crudpostgredeb.models;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "Funcionarios")
@Entity(name = "Funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int funcionario_id;
    public String nome;
    public String cargo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_responsavel_id")
    public List<Produtos> produtos;

}


