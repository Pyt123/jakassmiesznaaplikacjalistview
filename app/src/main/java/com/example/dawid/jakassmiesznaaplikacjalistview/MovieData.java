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
        Person [] actors = {new Person("Janusz", "Pawlacz", 2137, R.drawable.ricky),
                            new Person("Jan", "Paweł", 21, R.drawable.leslie_nielsen),
                            new Person("John", "Paul", 37, R.drawable.kapitan_bomba) };

        int [] imageIds = { R.drawable.kapitan_bomba, R.drawable.leslie_nielsen, R.drawable.ricky,
                            R.drawable.kapitan_bomba, R.drawable.leslie_nielsen, R.drawable.ricky };

        Movie [] movies = { new Movie("Trailer Park Boys", "comedy", R.drawable.ricky, imageIds, actors),
                new Movie("Kapitan Bomba", "sci-fi", R.drawable.kapitan_bomba, imageIds, actors),
                new Movie("The Naked Gun", "comedy", R.drawable.leslie_nielsen, imageIds, actors)};

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
