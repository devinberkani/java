package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }


    // FIX THIS****
    private Song findSong(String title) {
        for(int i = 0; i < this.songs.size(); i++){
            String songTitle = this.songs.get(i).getTitle();
            if(songTitle == title) {
                return this.songs.get(i);
            }
        }
        return null;
    }

    // ...OR THIS *****
    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            Song newSong = new Song(title, duration);
            this.songs.add(newSong);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if(this.songs.size() >= trackNumber && trackNumber > 0) {
            if (findSong(this.songs.get(trackNumber - 1).getTitle()) != null) {
                playlist.add(this.songs.get(trackNumber - 1));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        if(findSong(title) != null) {
            playlist.add(findSong(title));
            return true;
        }
        return false;
    }

}
