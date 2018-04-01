package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

public abstract class MovieInfoFragment extends Fragment
{
    public static final FragmentState DEFAULT_FRAGMENT_STATE = FragmentState.PICS;

    protected int movieIndex = -1;
    protected Movie movie = null;
    protected IMovieFragmentActivity context;

    public enum FragmentState { PICS, ACTORS };
    protected FragmentState fragmentState = DEFAULT_FRAGMENT_STATE;

    public MovieInfoFragment()
    {
    }

    @Override
    public void onStart()
    {
        super.onStart();
        movieIndex = getArguments().getInt(SpecificIMovieActivity.MOVIE_INDEX_KEY);
        movie = MovieData.getInstance().getData().get(movieIndex);
        setFragmentListener();
    }

    protected abstract void setFragmentListener();

    public FragmentState getFragmentState()
    {
        return fragmentState;
    }

    public void setContext(IMovieFragmentActivity context)
    {
        this.context = context;
    }
}
