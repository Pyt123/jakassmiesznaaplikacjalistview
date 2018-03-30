package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener
{
    private RecyclerView recyclerView = null;
    private static RecyclerView.Adapter recyclerAdapter = null;
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
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position)
    {
        if (viewHolder instanceof MovieAdapter.Item)
        {
            removeMovieFromData(viewHolder.getAdapterPosition());
        }
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupAdapter()
    {
        recyclerAdapter = new MovieAdapter(this, data);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
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
        recyclerAdapter.notifyDataSetChanged();
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
        recyclerAdapter.notifyDataSetChanged();
    }
}