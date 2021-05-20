package com.example.alocacaoprofessor.model;

public class Professor {
    private int id;
    private String name;
    private String cpf;
    private Departamento departament;

    public Professor(int id, String name, String cpf, Departamento departament) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.departament = departament;
    }

    public Professor() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Departamento getDepartament() {
        return departament;
    }

    public void setDepartament(Departamento departament) {
        this.departament = departament;
    }
}
