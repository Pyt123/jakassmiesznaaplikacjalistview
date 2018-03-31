package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificMovieActivity extends AppCompatActivity
{
    public static final String MOVIE_INDEX_KEY = "actor_index_key";

    private enum FragmentState { PICS, ACTORS };

    private FragmentState fragmentState = FragmentState.ACTORS;
    private Movie movie;
    private TextView nameText = null;
    private TextView categoryText = null;
    private ImageView mainImage = null;
    private ViewGroup fragmentContainer = null;

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
        setupFragment(fragmentState);
        setFragmentListener();
        int k = 0;
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

    private void setupFragment(FragmentState fragmentStateToSet)
    {
        fragmentContainer = findViewById(R.id.fragment_container);
        MovieInfoFragment fragment = null;
        switch (fragmentStateToSet)
        {
            case PICS:
                fragment = new MoviePicsFragment();
                break;

            case ACTORS:
                fragment = new MovieActorsFragment();
                break;
        }
        fragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void setFragmentListener()
    {
        fragmentContainer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(fragmentState == FragmentState.PICS)
                {
                    setupFragment(FragmentState.ACTORS);
                    fragmentState = FragmentState.ACTORS;
                }
                else
                {
                    setupFragment(FragmentState.PICS);
                    fragmentState = FragmentState.PICS;
                }
            }
        });
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
