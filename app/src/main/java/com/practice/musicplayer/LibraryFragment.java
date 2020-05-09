package com.practice.musicplayer;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.practice.musicplayer.Adapters.SongCardAdapter;
import com.practice.musicplayer.Models.SongCardModel;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.library_fragment, container, false);
        RecyclerView libraryRecyclerView = rootView.findViewById(R.id.library_recyclerview);



        ArrayList<SongCardModel> list = new ArrayList<>();
        list.add(new SongCardModel(R.drawable.roses_cover, "Roses"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Lily"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Sunflower"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Lotus"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Tulip"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Lavender"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Marigold"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Dandelion"));
        list.add(new SongCardModel(R.drawable.roses_cover, "Phytoplankton"));

        SongCardAdapter adapter = new SongCardAdapter(list, getActivity());
        libraryRecyclerView.setAdapter(adapter);


        //for the linear scroll use
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        libraryRecyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
//        libraryRecyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        libraryRecyclerView.setLayoutManager(gridLayoutManager);


        // Inflate the layout for this fragment
        return rootView;
    }
}
