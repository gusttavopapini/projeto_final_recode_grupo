package com.example.alocacaoprofessor.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Curso;

import java.util.List;

public class CursoAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private List<Curso> objects;

    public CursoAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Curso curso = objects.get(position);

        ImageView imageView = view.findViewById(R.id.ivImagem);
        TextView tvNomeCurso = view.findViewById(R.id.tvItemTitle);
        TextView tvProfessorAlocado = view.findViewById(R.id.tvProfessor);

        imageView.setImageResource(R.drawable.conta_privada);
        tvNomeCurso.setText(curso.getName());
        tvProfessorAlocado.setText("Professor Rafael");

        if (curso.getId() == 381) {
            tvNomeCurso.setTextColor(context.getColor(R.color.teal_700));
            tvProfessorAlocado.setText(context.getString(R.string.test_string));
        }

        return view;
    }
}
