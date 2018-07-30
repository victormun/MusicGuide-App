package com.example.android.musicguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create an ArrayList containing the songs
    private ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add the songs to the ArrayList
        songs.add(new Song("Self Esteem", "The Offspring", "Smash", "The_Offspring_Smash?id=B5tioiquzjdgsbu7vyc3m6kexma", R.drawable.theoffspring_smash));
        songs.add(new Song("The Battle Of The Pelennor Fields", "Howard Shore", "The Lord Of The Rings: The Return Of The King (Complete Recordings)", "Howard_Shore_The_Lord_Of_The_Rings_The_Return_Of_T?id=Beumg7kg2pk53cjj4io7uqaqzfu", R.drawable.lotr_3));
        songs.add(new Song("Come What May", "Ewan McGregor & Nicole Kidman", "Album", "Various_Artists_Moulin_Rouge_Soundtrack_Internatio?id=B3y5t2m6khn42awfbfaxpvxrw24", R.drawable.moulin_rouge));
        songs.add(new Song("What About Us", "P!nk", "Beautiful Trauma", "P_nk_Beautiful_Trauma?id=Bgx426zq75nccma5wddup7a6jhm", R.drawable.pink_beautiful_trauma));
        songs.add(new Song("Perfect", "Ed Sheeran", "÷", "Ed_Sheeran?id=B7u7bbifhpyfjn5svhagliayvvu", R.drawable.edsheeran_divide));
        songs.add(new Song("Thunder", "Imagine Dragons", "Evolve", "Imagine_Dragons_Evolve?id=B5ajs37gooyyku2qrkqc3ructey", R.drawable.imaginedragons_evolve));
        songs.add(new Song("Nothing Else Matters", "Metallica", "S&M", "Metallica_S_M?id=Brcd7jb5qhnclbs3nqqfprou4ey", R.drawable.metallica_sm));
        songs.add(new Song("Skyscraper", "Demi Lovato", "Unbroken", "Demi_Lovato_Unbroken?id=Bgr2tqtlgfdqesvgzw7ckd4oi2a", R.drawable.demilovato_unbroken));
        songs.add(new Song("Thick Skin", "Leona Lewis", "I Am (Deluxe)", "Leona_Lewis_I_Am_Deluxe?id=B3qafxkbf43hzizl4q35l6mvv3u", R.drawable.leonalewis_iam));
        songs.add(new Song("Where Is The Edge", "Within Temptation", "The Unforgiving", "Within_Temptation_The_Unforgiving?id=B5j46gujju7cmrk4hwxzxf6cuve", R.drawable.withintemptation_unforgiving));
        songs.add(new Song("Rose", "James Horner", "Titanic: Original Motion Picture Soundtrack - Anniversary Edition", "James_Horner_Titanic_Original_Motion_Picture_Sound?id=B5tiphfvbyu32mz3ze26asepncy", R.drawable.titanic));
        songs.add(new Song("The Show Must Go On", "Queen", "Greatest Hits II (2011 Remaster) ", "Queen_Greatest_Hits_II_2011_Remaster?id=Byzd6sfe7xo3nid76gzwjoyrobq", R.drawable.queen_greatesthitsii));
        songs.add(new Song("Imaginary", "Evanescence", "Fallen", "Evanescence_Fallen?id=Boz7eb6mrejjh5ziejx7cydvl5a", R.drawable.evanescence_fallen));
        songs.add(new Song("Quédate conmigo (versión Bakú)", "Pastora Soler", "Una mujer como yo", "album?id=Bind4x5rxygv2bibuo6czl6bzby&tid=song-Tdmcbxj4rl7kk3doa2lypht5sli", R.drawable.pastorasoler_quedateconmigo));
        songs.add(new Song("Telephone", "Lady Gaga (feat. Beyoncé)", "The Fame Monster", "Lady_Gaga_The_Fame_Monster?id=B5t7w66ic4dqvfzfg3lse6v7ncy", R.drawable.ladygaga_famemonster));
        songs.add(new Song("Viking Death March", "Billy Talent", "Dead Silence", "Billy_Talent_Dead_Silence?id=Bknp56qzsw5nwvmis67ckuj2soq", R.drawable.billytalent_deadsilence));
        songs.add(new Song("Knights of Cydonia", "Muse", "Black Holes And Revelations", "Muse_Black_Holes_And_Revelations?id=Bee5egllvct7kjzbrw3goapfx5y", R.drawable.muse_blackholesandrevelations));
        songs.add(new Song("The Kids Aren't Alright", "The Offspring", "Americana", "album?id=Bycowp4vdcv3r7hcsnp63bni2zq&tid=song-Tqypzbnuwclufdbd3o7wcun6y34", R.drawable.theoffspring_americana));
        songs.add(new Song("Let It Go", "Idina Menzel", "Frozen (Original Motion Picture Soundtrack) ", "Various_Artists_Frozen_Original_Motion_Picture_Sou?id=Bnfjhf64cbhrc63os7ekdjri5im", R.drawable.variousartists_frozenost));
        songs.add(new Song("In The End", "Linkin Park", "Hybrid Theory", "Linkin_Park_Hybrid_Theory_U_S_Version?id=Bvj27zbdf7rh6irckwito4hgdty", R.drawable.linkinpark_hybridtheory));

        // Create a new adapter for the listview
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the listview and set the previous adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        /**
         * Define Listener to call the intent to open the new activity and pass the current song
         * variables such as title, artist, etc.
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song selectedSong = songs.get(position);

                Intent intent = new Intent(getApplicationContext(), SongInformation.class);
                intent.putExtra("song", selectedSong.getSongName());
                intent.putExtra("artist", selectedSong.getArtistName());
                intent.putExtra("album", selectedSong.getAlbumName());
                intent.putExtra("packageName", selectedSong.getPackageName());
                intent.putExtra("coverId", selectedSong.getCoverId());
                startActivity(intent);

            }
        });

    }
}
