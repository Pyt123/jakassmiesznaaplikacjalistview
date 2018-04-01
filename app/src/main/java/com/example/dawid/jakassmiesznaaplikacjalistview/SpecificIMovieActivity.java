package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SpecificIMovieActivity extends AppCompatActivity
{
    public static final String MOVIE_INDEX_KEY = "actor_index_key";

    private Movie movie;
    private TextView nameText = null;
    private TextView categoryText = null;
    private ImageView mainImage = null;
    private MovieInfoFragment infoFragment = null;

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

    public void setupFragment()
    {
        ViewPager fragmentContainer = findViewById(R.id.fragment_container);
        ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        fragmentContainer.setAdapter(mPagerAdapter);
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


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter
    {
        MovieInfoFragment.FragmentState [] states;
        public ScreenSlidePagerAdapter(FragmentManager fm)
        {
            super(fm);
            states = MovieInfoFragment.FragmentState.values();
        }

        @Override
        public Fragment getItem(int position)
        {
            MovieInfoFragment fragment = MovieInfoFragment.initFragment(states[position]);
            fragment.setArguments(getIntent().getExtras());
            return fragment;
        }

        @Override
        public int getCount()
        {
            return states.length;
        }
    }
}