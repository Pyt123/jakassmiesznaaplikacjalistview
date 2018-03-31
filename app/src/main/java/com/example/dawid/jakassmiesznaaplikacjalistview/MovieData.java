package com.example.dawid.jakassmiesznaaplikacjalistview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieData
{
    private static final MovieData instance = new MovieData();
    public static MovieData getInstance()
    {
        return instance;
    }

    private List<Movie> data = new ArrayList<>();

    private MovieData()
    {
        initSomeData();
    }

    private void initSomeData()
    {
        Movie [] movies = { new Movie("Trailer Park Boys", "comedy", R.drawable.ricky, null, null),
                new Movie("Kapitan Bomba", "sci-fi", R.drawable.kapitan_bomba, null, null),
                new Movie("The Naked Gun", "comedy", R.drawable.leslie_nielsen, null, null)};

        Random generator = new Random();
        int index = 0;
        for(int i = 0; i < 15; i ++)
        {
            index  = (index + 1 + generator.nextInt(movies.length-1)) % movies.length;
            data.add(movies[index]);
        }
    }

    public List<Movie> getData()
    {
        return data;
    }
}
