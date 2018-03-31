package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.app.Fragment;

public abstract class MovieInfoFragment extends Fragment
{
    protected int movieIndex = -1;
    protected Movie movie = null;

    @Override
    public void onStart()
    {
        super.onStart();
        movieIndex = getArguments().getInt(SpecificMovieActivity.MOVIE_INDEX_KEY);
        movie = MovieData.getInstance().getData().get(movieIndex);
    }
}
