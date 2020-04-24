package com.practice.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar customToolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(customToolbar);
    }

    //to add menu to the app bar we need to inflate the menu first
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater customMenuInflater = getMenuInflater();
        //if the menu does not work try to restart the android studio after clearing the cache its in the File option
        customMenuInflater.inflate(R.menu.custom_app_bar_menu, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    //actions when the items on the menu are clicked
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                //open the search bar fragment
                return true;
            case R.id.action_settings:
                //open the settings activity
                return true;
            case R.id.action_account:
                //open the account activity
                return true;
            default:
                //we can't recognise the user action so
                //super class will handel it
                return super.onOptionsItemSelected(item);
        }
    }
}
