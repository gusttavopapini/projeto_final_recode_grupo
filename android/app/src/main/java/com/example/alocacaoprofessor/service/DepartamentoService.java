package com.example.alocacaoprofessor.service;

import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.model.DepartamentoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DepartamentoService {

    @GET("departament")
    Call<List<Departamento>> getTodosOsDepartamentos();

    @GET("departament/{id}")
    Call<DepartamentoDTO> getDepartamentoByID(@Path("id") int idDepartamento);

}
