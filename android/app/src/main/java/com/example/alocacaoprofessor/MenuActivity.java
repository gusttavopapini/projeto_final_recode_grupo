package com.example.alocacaoprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alocacaoprofessor.view.DepartamentoActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirTelaDepartamento(View view) {
        Intent intent = new Intent(this, DepartamentoActivity.class);
        startActivity(intent);
    }

}