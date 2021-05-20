package com.example.alocacaoprofessor.service;

import com.example.alocacaoprofessor.model.Curso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CursoService {

    @GET("course")
    Call<List<Curso>> getCursos();

}
