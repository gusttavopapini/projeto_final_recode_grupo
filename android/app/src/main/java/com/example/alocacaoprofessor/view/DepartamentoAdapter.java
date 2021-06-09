package com.example.alocacaoprofessor.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Department;

import java.util.List;

public class DepartamentoAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Department> objects;

    public DepartamentoAdapter(@NonNull Context context, int resource, @NonNull List objects) {
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

        Department department = objects.get(position);

        TextView tvNomeDepartamento = view.findViewById(R.id.tvItemTitle);
        tvNomeDepartamento.setText(department.getName());


      //  TextView tvIdDepartamento = view.findViewById(R.id.idDepartment)
        // tvIdDepartamento.setId(R.id.idDepartment);

        return view;
    }
}
