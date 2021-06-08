package com.example.alocacaoprofessor.model;

import java.util.List;

public class CursoDTO {
    private List<Curso> cursos;
    private int id;
    private String name;

    public CursoDTO(List<Curso> cursos, int id, String name) {
        this.cursos = cursos;
        this.id = id;
        this.name = name;
    }

    public CursoDTO() {
    }

    public List<Curso> getCourses() {
        return cursos;
    }

    public void setCourses(List<Curso> cursos) {
        this.cursos = cursos;
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