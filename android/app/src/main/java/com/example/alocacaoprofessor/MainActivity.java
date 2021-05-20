package com.example.alocacaoprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alocacaoprofessor.dao.RoomConfiguration;
import com.example.alocacaoprofessor.model.Curso;
import com.example.alocacaoprofessor.repository.RetrofitConfiguration;
import com.example.alocacaoprofessor.view.CursoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lvListView);

        RetrofitConfiguration configuration = new RetrofitConfiguration();

        RoomConfiguration roomConfiguration = RoomConfiguration.getInstance(this);

        Call<List<Curso>> call = configuration.getCursosService().getCursos();

        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {

                List<Curso> cursoList = response.body();

                roomConfiguration.cursoDAO().insertAll(cursoList);


                CursoAdapter adapter = new CursoAdapter(MainActivity.this, R.layout.item_list, cursoList);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na requisição", Toast.LENGTH_SHORT).show();
            }
        });

    }
}