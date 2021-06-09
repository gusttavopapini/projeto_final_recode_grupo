package com.example.alocacaoprofessor.repository;

import com.example.alocacaoprofessor.service.DepartamentoService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguration {

    private Retrofit retrofit;

    public RetrofitConfiguration() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://projeto-recodeiv.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public DepartamentoService getDepartamentoService() {
        return retrofit.create(DepartamentoService.class);
    }

}
