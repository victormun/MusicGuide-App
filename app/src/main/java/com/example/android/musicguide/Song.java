package com.example.android.musicguide;

/**
 * Created by Victor on 15/02/2018.
 */
public class Song {
    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private String mPackageName;
    private int mCoverId;

    /**
     * The constructor receives the information of each song that should be created
     * @param songName refers to the Song title.
     * @param artistName refers to the Artist name.
     * @param albumName refers to the Album name.
     * @param packageName refers to the URL where the Song can be bought.
     * @param coverId refers to the file name of the cover image.
     */
    public Song(String songName, String artistName, String albumName, String packageName, int coverId){
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mPackageName = packageName;
        mCoverId = coverId;
    }

    /**
     * Getter for the Song title
     * @return sends back the Song title.
     */
    public String getSongName(){
        return mSongName;
    }

    /**
     * Getter for the Artist name
     * @return sends back the Artist name.
     */
    public String getArtistName(){
        return mArtistName;
    }

    /**
     * Getter for the Album name
     * @return sends back the Album name.
     */
    public String getAlbumName(){
        return mAlbumName;
    }

    /**
     * Getter for the package name of the URL in Google Play
     * @return sends back the package name.
     */
    public String getPackageName(){
        return mPackageName;
    }

    /**
     * Getter for the cover ID string of the cover image of the album
     * @return sends back the package name.
     */
    public int getCoverId() {return mCoverId; }
}
