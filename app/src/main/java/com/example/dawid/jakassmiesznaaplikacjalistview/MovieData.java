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

    private final static int HOW_MANY_MOVIES = 15;
    private List<Movie> data = new ArrayList<>(HOW_MANY_MOVIES);

    private MovieData()
    {
        initSomeData();
    }

    private void initSomeData()
    {
        Person [] actors = {new Person("Ryszard", "Kotys", 86, R.drawable.menda),
                            new Person("Robb", "Wells", 47, R.drawable.ricky),
                            new Person("Mateusz", "Król", 29, R.drawable.wutka),
                            new Person("Michał", "Żebrowski", 47, R.drawable.zebrowski),
                            new Person("John", "Bradley-West", 29, R.drawable.sam)};

        int [] imageIds0 = { R.drawable.bebech, R.drawable.wypadki, R.drawable.plantacja,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };
        int [] imageIds1 = { R.drawable.tron, R.drawable.kutnapletes, R.drawable.kodeks,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };
        int [] imageIds2 = { R.drawable.nibytak, R.drawable.diabel, R.drawable.trzech_wspanialych2,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };
        int [] imageIds3 = { R.drawable.zebr_zam, R.drawable.menda, R.drawable.smok,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };
        int [] imageIds4 = { R.drawable.wutka, R.drawable.korona_konno, R.drawable.cudka,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };
        int [] imageIds5 = { R.drawable.gra1, R.drawable.lodka, R.drawable.gra2,
                             R.drawable.kapitan_bomba, R.drawable.zebrowski, R.drawable.ricky };


        Movie [] movies = { new Movie("Chłopaki z baraków", "komedia", R.drawable.ricky, imageIds0, actors),
                new Movie("Kapitan Bomba", "sci-fi", R.drawable.kapitan_bomba, imageIds1, actors),
                new Movie("Świat według Kiepskich", "komedia", R.drawable.trzech_wspanialych, imageIds2, actors),
                new Movie("Wiedźmin", "fantasy", R.drawable.zebrowski, imageIds3, actors),
                new Movie("Korona Królów", "propagandowy", R.drawable.korona, imageIds4, actors),
                new Movie("Gra o Tron", "fantasy", R.drawable.gra_o_tron, imageIds5, actors)};

        Random generator = new Random();
        int index = 0;
        for(int i = 0; i < HOW_MANY_MOVIES; i ++)
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
