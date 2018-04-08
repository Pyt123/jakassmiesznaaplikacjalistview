package com.example.dawid.jakassmiesznaaplikacjalistview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie
{
    private String name;
    private String category;
    private int mainImageId;
    private int [] imageIds;
    private List<Person> actors;

    public Movie(String name, String category, int mainImageId, int [] imageIds, Person [] actors)
    {
        this.name = name;
        this.category = category;
        this.mainImageId = mainImageId;
        this.imageIds = imageIds;
        this.actors = new ArrayList<>(Arrays.asList(actors));
    }

    public String getMovieName()
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public int getMainImageId()
    {
        return mainImageId;
    }

    public int[] getImageIds()
    {
        return imageIds;
    }

    public List<Person> getActors()
    {
        return actors;
    }
}
