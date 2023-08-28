package com.example.crudpostgredeb.models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotorisaRepository extends JpaRepository<Motorista, Integer> {

    @Modifying
    @Query("UPDATE motorista  set ativo = :status WHERE id_motorista = :id")
    int updateMotorista(@Param("status")int status, @Param("id") int id);
}
