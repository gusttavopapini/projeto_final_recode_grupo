package com.example.alocacaoprofessor.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Curso {

    @PrimaryKey
    private int id;
    private String name;

    public Curso(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Curso() {
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
