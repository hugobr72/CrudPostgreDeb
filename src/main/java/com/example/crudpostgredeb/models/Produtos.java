package com.example.crudpostgredeb.models;


import jakarta.persistence.*;


@Table(name = "produtos")
@Entity(name = "produtos")
public class Produtos {
    @Id
    public int produto_id;
    public String nome;
    public String descricao;
    @Column(name = "funcionario_responsavel_id ")
    public String funcionario_responsavel_id;

}
