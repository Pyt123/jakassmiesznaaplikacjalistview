package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificMovieActivity extends AppCompatActivity
{
    private static final String MOVIE_INDEX_KEY = "actor_index_key";

    private Movie movie;
    private TextView nameText = null;
    private TextView categoryText = null;
    private ImageView mainImage = null;

    public static void start(Context context, int movieIndex)
    {
        Intent starter = new Intent(context, SpecificMovieActivity.class);
        starter.putExtra(MOVIE_INDEX_KEY, movieIndex);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_movie);
        setupToolbar();

        setupMovieData();
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupMovieData()
    {
        getMovie();
        findViews();
        setMovieDataToViews();
    }

    private void getMovie()
    {
        Bundle extras = getIntent().getExtras();
        int movieIndex = getIntent().getExtras().getInt(MOVIE_INDEX_KEY);
        movie = MovieData.getInstance().getData().get(movieIndex);
    }

    private void findViews()
    {
        nameText = findViewById(R.id.movie_name);
        categoryText = findViewById(R.id.movie_category);
        mainImage = findViewById(R.id.main_image);
    }

    private void setMovieDataToViews()
    {
        nameText.setText(movie.getMovieName());
        categoryText.setText(movie.getCategory());
        mainImage.setImageResource(movie.getMainImageId());
    }
}
