package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private ArrayAdapter arrayAdapter;

    public static List<Person> data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent intent = new Intent(this, AddingItemActivity.class);
        //startActivity(intent);
        setupToolbar();

        initData();


        listView = findViewById(R.id.list_view);
        arrayAdapter = new PersonAdapter(getApplicationContext(), R.layout.row, data);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View clickedRow, int i, long l)
            {
                TextView name = clickedRow.findViewById(R.id.name);
                TextView surname = clickedRow.findViewById(R.id.surname);
                TextView date = clickedRow.findViewById(R.id.date_input);
                Toast.makeText(getApplicationContext(),
                        name.getText() + " " + surname.getText() + "\n" + date.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
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

    private void initData()
    {
        data = new LinkedList<>();
        data.add(new Person("Jan", "Kowalski", "2007, 3, 29"));
        data.add(new Person("Albert", "Abacki", "2007, 12, 19"));
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}