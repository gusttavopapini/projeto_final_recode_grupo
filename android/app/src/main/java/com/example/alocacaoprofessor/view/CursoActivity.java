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

        getAllItemsByServer();

    }

    private void getAllItemsByServer() {

        RetrofitConfiguration retrofitConfiguration = new RetrofitConfiguration();
        Call<List<Curso>> service = retrofitConfiguration.getCursosService().getTodosOsDepartamentos();

        service.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                if (response.isSuccessful()) {
                    List<Departamento> departamentos = response.body();
                    listObject.addAll(departamentos);
                    adapter.notifyDataSetChanged();

                    for (Departamento departamento : listObject) {
                        Log.i(DepartamentoActivity.class.getSimpleName(), departamento.getName());
                    }

                } else {
                    String mensagemErro = response.errorBody().toString();
                    Toast.makeText(DepartamentoActivity.this, mensagemErro, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {
                Toast.makeText(DepartamentoActivity.this, "Requisição para API de Departamento falhou", Toast.LENGTH_SHORT).show();
            }
        });

    }

}