package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private static ArrayAdapter arrayAdapter = null;
    private static List<Movie> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupAdapter();
        initSomeData();
        setRecyclerViewListeners();
    }

    private void setRecyclerViewListeners()
    {
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupAdapter()
    {
        arrayAdapter = new MovieAdapter(getApplicationContext(), R.layout.movie_row, data);
        recyclerView = findViewById(R.id.list_view);
        recyclerView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static void removeMovieFromData(int i)
    {
        data.remove(i);
        arrayAdapter.notifyDataSetChanged();
    }

    private void initSomeData()
    {
        Movie [] movies = { new Movie("Trailer Park Boys", "comedy", R.drawable.ricky),
                            new Movie("Kapitan Bomba", "sci-fi", R.drawable.kapitan_bomba),
                            new Movie("The Naked Gun", "comedy", R.drawable.leslie_nielsen)};

        Random generator = new Random();
        int index = 0;
        for(int i = 0; i < 15; i ++)
        {
            index  = (index + 1 + generator.nextInt(movies.length-1)) % movies.length;
            data.add(movies[index]);
        }
        arrayAdapter.notifyDataSetChanged();
    }
}