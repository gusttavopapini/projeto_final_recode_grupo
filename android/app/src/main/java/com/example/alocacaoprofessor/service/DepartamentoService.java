package com.example.alocacaoprofessor.service;

import com.example.alocacaoprofessor.model.Department;
import com.example.alocacaoprofessor.model.DepartamentoDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DepartamentoService {

    @GET("departments")
    Call<List<Department>> getTodosOsDepartamentos();

    @GET("departments/{id}")
    Call<DepartamentoDTO> getDepartamentoByID(@Path("id") int idDepartamento);

}
