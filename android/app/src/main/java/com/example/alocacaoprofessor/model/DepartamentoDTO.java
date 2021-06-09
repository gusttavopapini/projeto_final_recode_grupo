package com.example.alocacaoprofessor.model;

import java.util.List;

public class DepartamentoDTO {
    private int id;
    private String name;

    public DepartamentoDTO(List<Department> departments, int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartamentoDTO() {
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
