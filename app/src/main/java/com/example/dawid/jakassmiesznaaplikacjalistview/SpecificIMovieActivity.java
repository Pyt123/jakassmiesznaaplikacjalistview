package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificIMovieActivity extends AppCompatActivity implements IMovieFragmentActivity
{
    public static final String MOVIE_INDEX_KEY = "actor_index_key";

    private Movie movie;
    private TextView nameText = null;
    private TextView categoryText = null;
    private ImageView mainImage = null;
    private MovieInfoFragment infoFragment = null;
    private ViewGroup fragmentContainer;

    public static void start(Context context, int movieIndex)
    {
        Intent starter = new Intent(context, SpecificIMovieActivity.class);
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
        fragmentContainer = findViewById(R.id.fragment_container);
        setupFragment();
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

    public void setupFragment() //TODO: cholera wie, ale ma być public póki co
    {
        MovieInfoFragment.FragmentState state = MovieInfoFragment.DEFAULT_FRAGMENT_STATE;
        if(infoFragment != null)
        {
            state = infoFragment.getFragmentState();
        }
        switch (state)
        {
            case PICS:
                infoFragment = new MoviePicsFragment();
                break;

            case ACTORS:
                infoFragment = new MovieActorsFragment();
                break;
        }
        infoFragment.setContext(this);
        infoFragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, infoFragment).commit();
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

interface IMovieFragmentActivity
{
    void setupFragment();
}
