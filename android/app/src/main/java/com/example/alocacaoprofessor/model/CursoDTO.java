package com.example.alocacaoprofessor.model;

import java.util.List;

public class CursoDTO {
    private List<Curso> Curso;
    private int id;
    private String name;

    public CursoDTO(List<Curso>Curso, int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CursoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}