package com.madscientistlaboratories.songr.controllers;


import com.madscientistlaboratories.songr.models.Album;
import com.madscientistlaboratories.songr.models.AlbumRepository;
import com.madscientistlaboratories.songr.models.Song;
import com.madscientistlaboratories.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
    public class SongController{
        @Autowired
        SongRepository songRepository;
        @Autowired
        AlbumRepository albumRepository;

        @GetMapping("/songs")
        public String getAllSongs(Model m){
            List<Song> songs = songRepository.findAll();
            m.addAttribute("songs", songs);
            return "songs";
        }

        @GetMapping("/song/{title}")
        public String getASong(@PathVariable String title, Model m){
            Song s = songRepository.findByTitle(title);
            m.addAttribute("song", s);
            return "song";
        }

        @PostMapping("/songs")
        public RedirectView addSong(String title, int trackNumber, String album ) {
            Album a = albumRepository.findByTitle(album);
            Song m = songRepository.findByTitleAndAlbum(title, a);

            if ( m == null){
                m = new Song(title, trackNumber, a);
                songRepository.save(m);
            }

            return new RedirectView("/songs");
        }



    }

