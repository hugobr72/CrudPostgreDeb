package com.example.crudpostgredeb.models;
import java.util.Date;
import jakarta.persistence.*;


@Table(name = "motorista")
@Entity(name = "motorista")
public class Motorista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id_motorista;

    public String nome;
    public String cpf;
    public String telefone;
    public String email;
    public String cnh;
    public Date cnh_validade;
    public String pais;
    public Date data_registro;
    @Column(name = "codmotoristastatus")
    public int codMotoristaStatus;
    public int ativo;
    public Date dth_treinamento_realizado;
    public Date dth_treinamento_validade;

    public Motorista(){
        this.ativo = 0;
        this.codMotoristaStatus = 0;
        this.cnh = "";
        this.pais = "";
        this.email = "";
        this.telefone = "";
    }

}
