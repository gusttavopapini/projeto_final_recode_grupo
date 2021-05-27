package com.example.alocacaoprofessor.service;

import com.example.alocacaoprofessor.model.Curso;
import com.example.alocacaoprofessor.model.CursoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getAllCursos();

    @GET("course/{id}")
    Call<CursoDTO> getCursoByID(@Path("id") int idCurso);

}
