package com.practice.musicplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LibraryFragment extends Fragment {
    RecyclerView libraryRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //finding the recycler view inside the fragment
        libraryRecyclerView = libraryRecyclerView.findViewById(R.id.library_recyclerview);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.library_fragment, container, false);
    }
}
