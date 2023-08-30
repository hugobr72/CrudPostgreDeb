package com.example.crudpostgredeb.services;

import com.example.crudpostgredeb.models.Funcionarios;
import com.example.crudpostgredeb.models.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionarios> GetAll(){
        try {
            return repository.findAll();
        }catch (Exception e){
            return null;
        }
    }

    public Funcionarios GetById(int id){
        try {
            return repository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    public String CreateFuncionario(Funcionarios funcionario){
        try {
            if(funcionario.nome == null){
                return "O funcionario precisa de um nome para ser criado";
            }

            if(funcionario.cargo == null){
                return "O funcionario precisa de um cargo para ser criado";
            }
            repository.save(funcionario);
            return "Funcionario Criado com sucesso";
        }catch (Exception e){
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }

    public String UpdateFuncionario(Funcionarios funcionario){
        try {
            var produto = GetById(funcionario.funcionario_id);
            if(produto == null){
                return "O funcionario não existe";
            }
            funcionario.produtos = produto.produtos;
            var result = repository.save(funcionario);
            return "Funcionario editado com sucesso";
        }catch (Exception e){
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }
    public String DeleteFuncionario(int id){
        try {
            if(GetById(id) == null){
                return "O funcionario não existe";
            }
            repository.deleteById(id);
            return "Funcionario deletado com sucesso!";
        }catch (Exception e){
            return "Ocorreu um erro, tente novamente mais tarde!" + e.getMessage();
        }
    }

}
