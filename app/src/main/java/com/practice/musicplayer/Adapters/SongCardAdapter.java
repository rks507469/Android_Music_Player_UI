package com.practice.musicplayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.musicplayer.LibraryFragment;
import com.practice.musicplayer.Models.SongCardModel;
import com.practice.musicplayer.R;

import java.util.ArrayList;

public class SongCardAdapter extends  RecyclerView.Adapter<SongCardAdapter.viewHolder> {

    private ArrayList<SongCardModel> list;
    private Context context;

    public SongCardAdapter(ArrayList<SongCardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.libray_recycler_view_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SongCardModel model = list.get(position);
        holder.albumArt.setImageResource(model.getImage());
        holder.songName.setText(model.getSongName());
    }

    @Override
    public int getItemCount() {
        //setting the size of the recyclerView to the size of the list
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        ImageView albumArt;
        TextView songName;
        viewHolder(@NonNull View itemView) {
            super(itemView);
            albumArt = itemView.findViewById(R.id.album_art);
            songName = itemView.findViewById(R.id.song_name);
        }
    }
}
