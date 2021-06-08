package com.example.alocacaoprofessor.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.alocacaoprofessor.model.Curso;

@Database(entities = {Curso.class}, version = 1)
public abstract class RoomConfiguration extends RoomDatabase {

    private static RoomConfiguration instance = null;

    public abstract CursoDAO cursoDAO();

    public static RoomConfiguration getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, RoomConfiguration.class, "Nome da base de dados")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
