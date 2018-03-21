package com.example.dawid.jakassmiesznaaplikacjalistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AddingItemActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_item);
        setupToolbar();
    }

    private void setupToolbar()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_adding_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.save_item_button:
                saveNewPerson();
                finish();
                return true;
            case android.R.id.home:
                saveNewPerson();
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveNewPerson()
    {
        EditText nameText = findViewById(R.id.name_input);
        EditText surnameText = findViewById(R.id.surname_input);
        EditText dateText = findViewById(R.id.date_input);

        Person person = new Person(nameText.getText().toString(),
                surnameText.getText().toString(), dateText.getText().toString());

        MainActivity.AddPersonToData(person);
    }
}
