package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person>
{
    private Context context = null;
    private int layoutResId;
    private List<Person> data = null;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.data = objects;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);

        row = inflater.inflate(layoutResId, parent, false);

        TextView nameView = row.findViewById(R.id.name);
        TextView surnameView = row.findViewById(R.id.surname);
        TextView dateView = row.findViewById(R.id.date_input);

        Person person = data.get(position);

        nameView.setText(person.getName());
        surnameView.setText(person.getSurname());
        dateView.setText(person.getDate());

        return row;
    }
}
