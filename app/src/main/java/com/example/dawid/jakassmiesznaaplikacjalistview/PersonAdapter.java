package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

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

        return row;
    }
}
