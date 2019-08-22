package com.madscientistlaboratories.songr.models;

import javax.persistence.*;

@Entity
public class Song {
//    instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    int trackNumber;

    @ManyToOne
    Album album;

//  constructor

    public Song(){}

    public Song(String title, int trackNumber, Album album) {
        this.title = title;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }
}
