package com.example.alocacaoprofessor.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.alocacaoprofessor.model.Curso;

import java.util.List;

@Dao
public interface CursoDAO {

    @Insert
    void insertAll(List<Curso> cursoList);

    @Query("SELECT * FROM Curso")
    List<Curso> getAllCursos();

}
