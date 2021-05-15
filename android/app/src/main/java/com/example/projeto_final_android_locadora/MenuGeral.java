package com.example.projeto_final_android_locadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuGeral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_geral);
    }

    public void fazerLogout(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}

