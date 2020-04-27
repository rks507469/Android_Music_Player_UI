package com.practice.musicplayer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //code for the things are populated when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating teh tool bar
        Toolbar customToolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(customToolbar);

        //creating the fragments view
        //checking for the fragment container
        if(findViewById(R.id.fragment_container) != null) {
            loadFragment(new LibraryFragment());
        }

        //Bottom navigation menu actions on the selection of the items
        //it will be used to trigger the functions to call the fragments
        //to load the fragments in the activity
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_library:
                        loadFragment(new LibraryFragment());
                        return true;
                    case R.id.navigation_for_you:
                        loadFragment(new ForYouFragment());
                        return true;
                    case R.id.navigation_browse:
                        loadFragment(new BrowseFragment());
                        return true;
                    case R.id.navigation_radio:
                        loadFragment(new RadioFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });

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
    //it is incomplete because we have'nt created any activities yet
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

    //function to load the fragment into the fragment container
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();




    }
}
