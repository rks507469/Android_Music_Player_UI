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
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            //creating the fragment
            LibraryFragment libraryFragment = new LibraryFragment();
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            libraryFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, libraryFragment).commit();
        }
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

    //Bottom navigation menu actions on the selection of the items
    //it will be used to trigger the functions to call the fragments
    //to load the fragments in the activity
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()) {
                case R.id.navigation_library:
                    //Library fragment
                    LibraryFragment libraryFragment = new LibraryFragment();
                    FragmentTransaction libraryFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    libraryFragmentTransaction.replace(R.id.fragment_container, libraryFragment);
                    libraryFragmentTransaction.addToBackStack(null);
                    libraryFragmentTransaction.commit();
                    return true;
                case R.id.navigation_for_you:
                    //ForYou fragment
                    ForYouFragment forYouFragment = new ForYouFragment();
                    FragmentTransaction forYouFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    forYouFragmentTransaction.replace(R.id.fragment_container, forYouFragment);
                    forYouFragmentTransaction.addToBackStack(null);
                    forYouFragmentTransaction.commit();
                    return true;
                case R.id.navigation_browse:
                    //ignore this for the moment
                    return  true;
                case R.id.navigation_radio:
                    //ignore this for the moment
                    return  true;
                default:
                    //ignore this for the moment
                    return false;
            }
        }
    };
}
