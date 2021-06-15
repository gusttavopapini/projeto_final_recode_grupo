package com.example.alocacaoprofessor.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Department;
import com.example.alocacaoprofessor.repository.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartamentoActivity extends AppCompatActivity {

    private List<Department> listObject = new ArrayList<>();
    private DepartamentoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);

        ListView departamentoList = findViewById(R.id.lvDepartamentolist);

        adapter = new DepartamentoAdapter(this, R.layout.item_list, listObject);
        departamentoList.setAdapter(adapter);

        getAllItemsByServer();

    }

    private void getAllItemsByServer() {

        RetrofitConfiguration retrofitConfiguration = new RetrofitConfiguration();
        Call<List<Department>> service = retrofitConfiguration.getDepartamentoService().getTodosOsDepartamentos();

        service.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if (response.isSuccessful()) {
                    List<Department> departments = response.body();
                    listObject.addAll(departments);
                    adapter.notifyDataSetChanged();

                    for (Department department : listObject) {
                        Log.i(DepartamentoActivity.class.getSimpleName(), department.getName());
                    }

                } else {
                    String messageError = response.errorBody().toString();
                    Toast.makeText(DepartamentoActivity.this, messageError, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                Toast.makeText(DepartamentoActivity.this, "Requisição para API de Departamento falhou", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void abrirTelaCreateNewDepartment(View view) {
        Intent intent = new Intent(this, DepartamentoAdd.class);
        startActivity(intent);
    }
}