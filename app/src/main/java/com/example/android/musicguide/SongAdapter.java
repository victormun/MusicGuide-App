package com.example.android.musicguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Victor on 15/02/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, List<Song> songs){
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song songs = getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.song_name);
        songName.setText(songs.getSongName());

        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        artistName.setText(songs.getArtistName());

        TextView albumName = (TextView) listItemView.findViewById(R.id.album_name);
        albumName.setText(songs.getAlbumName());

        ImageView albumCover = (ImageView) listItemView.findViewById(R.id.album_cover);
        albumCover.setImageResource(songs.getCoverId());

        return listItemView;
    }
}
