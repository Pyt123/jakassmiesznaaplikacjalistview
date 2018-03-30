package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie>
{
    private Context context = null;
    private int layoutResId;
    private List<Movie> data = null;

    public MovieAdapter(@NonNull Context context, int resource, @NonNull List<Movie> objects)
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

        row = inflater.inflate(layoutResId, parent, false);

        TextView nameView = row.findViewById(R.id.movie_name);
        TextView categoryView = row.findViewById(R.id.category);
        ImageView imageView = row.findViewById(R.id.movie_image);

        Movie movie = data.get(position);

        nameView.setText(movie.getName());
        categoryView.setText(movie.getCategory());
        imageView.setImageResource(movie.getImageId());

        return row;
    }
}