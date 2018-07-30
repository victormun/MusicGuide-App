package com.example.android.musicguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Victor on 15/02/2018.
 */

public class SongInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);

        // Retrieve the song title, artist, album, package name and cover ID from the previous activity
        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("song");
        String artist = intent.getStringExtra("artist");
        String album = intent.getStringExtra("album");
        final String packageName = intent.getStringExtra("packageName");
        int coverId = intent.getIntExtra("coverId", 0);

        // Assign the song's attributes to the layout
        TextView songName = (TextView) findViewById(R.id.si_song_name);
        songName.setText(songTitle);

        TextView artistName = (TextView) findViewById(R.id.si_artist_name);
        artistName.setText(artist);

        TextView albumName = (TextView) findViewById(R.id.si_album_name);
        albumName.setText(album);

        ImageView albumCover = (ImageView) findViewById(R.id.si_album_cover);
        albumCover.setImageResource(coverId);

        // Create a Listener attached to the button to open a link to buy the song
        Button button = (Button) findViewById(R.id.si_get_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/music/album/"+packageName));
                startActivity(i);
            }
        });

    }

}
