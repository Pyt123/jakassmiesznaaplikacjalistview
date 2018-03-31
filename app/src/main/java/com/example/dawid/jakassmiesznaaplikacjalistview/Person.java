package com.example.dawid.jakassmiesznaaplikacjalistview;

public class Person
{
    private String name;
    private String surname;
    private int age;
    private int imageId;

    public Person(String name, String surname, int age, int imageId)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.imageId = imageId;
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

    public int getImageId()
    {
        return imageId;
    }
}
