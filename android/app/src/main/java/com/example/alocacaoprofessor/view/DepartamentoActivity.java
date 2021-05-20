package com.example.alocacaoprofessor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.repository.RetrofitConfiguration;
import com.example.alocacaoprofessor.service.DepartamentoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartamentoActivity extends AppCompatActivity {

    private List<Departamento> listObject = new ArrayList<>();
    private DepartamentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);

        listObject.add(new Departamento(00021, "Departamento Teste - Aula 7"));

        ListView departamentoList = findViewById(R.id.lvDepartamentolist);

        adapter = new DepartamentoAdapter(this, R.layout.item_list, listObject);
        departamentoList.setAdapter(adapter);

        getAllItemsByServer();

    }

    private void getAllItemsByServer() {

        RetrofitConfiguration retrofitConfiguration = new RetrofitConfiguration();
        Call<List<Departamento>> service = retrofitConfiguration.getDepartamentoService().getTodosOsDepartamentos();

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