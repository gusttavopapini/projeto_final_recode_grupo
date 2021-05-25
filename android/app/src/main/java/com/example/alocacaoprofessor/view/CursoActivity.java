package com.example.alocacaoprofessor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Curso;
import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.repository.RetrofitConfiguration;
import com.example.alocacaoprofessor.service.DepartamentoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoActivity extends AppCompatActivity {

    private List<Curso> listObject = new ArrayList<>();
    private CursoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        listObject.add(new Curso(123, "Professor Gustavo"));

        ListView cursoList = findViewById(R.id.lvCursolist);

        adapter = new CursoAdapter(this, R.layout.item_list, listObject);
        cursoList.setAdapter(adapter);

        getAllItemsByServerCurso();

    }

    private void getAllItemsByServerCurso() {

        RetrofitConfiguration retrofitConfiguration = new RetrofitConfiguration();
        Call<List<Curso>> service = retrofitConfiguration.getCursosService().getAllCursos();

        service.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if (response.isSuccessful()) {
                    List<Curso> cursos = response.body();
                    listObject.addAll(cursos);
                    adapter.notifyDataSetChanged();

                    for (Curso curso : listObject) {
                        Log.i(CursoActivity.class.getSimpleName(), curso.getName());
                    }

                } else {
                    String mensagemErro = response.errorBody().toString();
                    Toast.makeText(CursoActivity.this, mensagemErro, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(CursoActivity.this, "Requisição para API de Curso falhou", Toast.LENGTH_SHORT).show();
            }
        });

    }

}