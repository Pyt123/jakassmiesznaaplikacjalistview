package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.media.Image;

public class Person
{
    private String name;
    private String surname;
    private int age;
    private Image image;

    public Person(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getAge()
    {
        return age;
    }

    public Image getImage()
    {
        return image;
    }
}
