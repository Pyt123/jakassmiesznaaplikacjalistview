package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;


public class MovieActorsFragment extends MovieInfoFragment
{
    public MovieActorsFragment()
    {
        super();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        setupListViewWithActors();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.movie_actors_fragment, container, false);
        return view;
    }

    private void setupListViewWithActors()
    {
        List<Person> actors = movie.getActors();
        ListView listView = getView().findViewById(R.id.list_view);
        listView.setAdapter(new PersonAdapter(getActivity(), R.layout.person_row, actors));
    }
}
