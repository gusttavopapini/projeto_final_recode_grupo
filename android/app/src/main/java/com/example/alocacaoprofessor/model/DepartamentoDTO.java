package com.example.alocacaoprofessor.model;

import java.util.List;

public class DepartamentoDTO {
    private List<Professor> professors;
    private int id;
    private String name;

    public DepartamentoDTO(List<Professor> professors, int id, String name) {
        this.professors = professors;
        this.id = id;
        this.name = name;
    }

    public DepartamentoDTO() {
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
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
