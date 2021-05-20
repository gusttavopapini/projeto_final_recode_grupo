package com.example.alocacaoprofessor.repository;

import com.example.alocacaoprofessor.service.CursoService;
import com.example.alocacaoprofessor.service.DepartamentoService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguration {

    private Retrofit retrofit;

    public RetrofitConfiguration() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CursoService getCursosService() {
        return retrofit.create(CursoService.class);
    }

    public DepartamentoService getDepartamentoService() {
        return retrofit.create(DepartamentoService.class);
    }

}
