package com.example.dawid.jakassmiesznaaplikacjalistview;

public class Movie
{
    private String name;
    private String category;

    private int mainImageId;
    private int [] imageIds;
    private Person [] actors;

    public Movie(String name, String category, int mainImageId, int [] imageIds, Person [] actors)
    {
        this.name = name;
        this.category = category;
        this.mainImageId = mainImageId;
        this.imageIds = imageIds;
        this.actors = actors;
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
}
