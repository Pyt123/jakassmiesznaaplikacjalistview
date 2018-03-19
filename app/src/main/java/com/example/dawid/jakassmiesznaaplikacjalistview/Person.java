package com.example.dawid.jakassmiesznaaplikacjalistview;

public class Person
{
    private String name;
    private String surname;
    private String date;

    public Person(String name, String surname, String date)
    {
        this.name = name;
        this.surname = surname;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getDate()
    {
        return date;
    }
}
