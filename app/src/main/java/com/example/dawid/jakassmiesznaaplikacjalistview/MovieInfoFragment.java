package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.support.v4.app.Fragment;

public abstract class MovieInfoFragment extends Fragment
{
    protected int movieIndex = -1;
    protected Movie movie = null;

    public enum FragmentState { ACTORS, PICS };

    @Override
    public void onStart()
    {
        super.onStart();
        movieIndex = getArguments().getInt(SpecificIMovieActivity.MOVIE_INDEX_KEY);
        movie = MovieData.getInstance().getData().get(movieIndex);
        setFragmentListener();
    }

    protected abstract void setFragmentListener();

    public static MovieInfoFragment initFragment(FragmentState state)
    {
        switch (state)
        {
            case ACTORS:
                return new MovieActorsFragment();
            case PICS:
                return new MoviePicsFragment();
        }
        return null;
    }
}
