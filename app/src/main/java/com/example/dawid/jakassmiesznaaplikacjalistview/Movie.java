package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.media.Image;

public class Movie
{
    private String name;
    private String category;
    private int imageId;

    public Movie(String name, String category, int imageId)
    {
        this.name = name;
        this.category = category;
        this.imageId = imageId;
    }

    public String getName()
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }

    public int getImageId()
    {
        return imageId;
    }
}
