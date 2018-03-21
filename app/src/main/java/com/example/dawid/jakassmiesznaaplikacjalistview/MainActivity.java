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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private static ArrayAdapter arrayAdapter = null;
    private static List<Person> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

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
            case R.id.add_button:
                Intent intent = new Intent(this, AddingItemActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public static void AddPersonToData(Person person)
    {
        data.add(person);
        arrayAdapter.notifyDataSetChanged();
    }

    public static void RemovePersonFromData(int i)
    {
        data.remove(i);
        arrayAdapter.notifyDataSetChanged();
    }

    private void initData()
    {
        Person p = new Person("d", "s", "2137");
        for(int i = 0; i < 15; i ++)
        {
            data.add(p);
        }
        arrayAdapter.notifyDataSetChanged();
    }
}