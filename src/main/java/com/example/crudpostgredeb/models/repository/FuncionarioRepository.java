package com.example.crudpostgredeb.models.repository;

import com.example.crudpostgredeb.models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios, Integer> {
}
