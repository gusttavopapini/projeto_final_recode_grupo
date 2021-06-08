package com.example.alocacaoprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alocacaoprofessor.view.DepartamentoActivity;
import com.example.alocacaoprofessor.view.DetalheDoItemActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirTelaCurso(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void abrirTelaDepartamento(View view) {
        Intent intent = new Intent(this, DepartamentoActivity.class);
        startActivity(intent);
    }

    public void abrirTelaDepartamentoDetalhes(View view) {
        Intent intent = new Intent(this, DetalheDoItemActivity.class);
        startActivity(intent);
    }
}