package com.example.crudpostgredeb.models;


import jakarta.persistence.*;


@Table(name = "produtos")
@Entity(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int produto_id;
    public String nome;
    public String descricao;
    @Column(name = "funcionario_responsavel_id ")
    public int funcionario_responsavel_id;

}
