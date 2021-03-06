package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person>
{
    private Context context = null;
    private int layoutResId;
    private List<Person> data = null;

    private TextView nameView = null;
    private TextView surnameView = null;
    private TextView ageView = null;
    private ImageView imageView = null;
    private Person person = null;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.layoutResId = resource;
        this.data = objects;
    }

    @Override
    public View getView(final int position, View row, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        //@SuppressWarnings(FrasStyle)
        row = inflater.inflate(layoutResId, parent, false);

        person = data.get(position);
        findViews(row);
        setProps();

        return row;
    }

    private void findViews(View row)
    {
        nameView = row.findViewById(R.id.name);
        surnameView = row.findViewById(R.id.surname);
        ageView = row.findViewById(R.id.age);
        imageView = row.findViewById(R.id.actor_pic);
    }

    private void setProps()
    {
        nameView.setText(person.getName());
        surnameView.setText(person.getSurname());
        ageView.setText(String.valueOf(person.getAge()));
        Glide.with(context).load(person.getImageId()).into(imageView);
    }
}
