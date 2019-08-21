package com.madscientistlaboratories.songr.controllers;


import com.madscientistlaboratories.songr.models.Album;
import com.madscientistlaboratories.songr.models.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

  @Controller
  public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
//        Album theAlbum = new Album("Forrest Gump", "Robert Zemeckis", Date.valueOf("1994-07-06"), 72.0, "PG-13");
//        Album secondAlbum = new Album("Shawshank Redemption", "Frank Darabont", Date.valueOf("1994-09-23"), 91.0, "R");
//        Album[] albums = new Album[]{theMovie, secondMovie};
      List<Album> albums = albumRepository.findAll();
      m.addAttribute("albums", albums);
      return "albums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
      Album m = new Album(title, artist, songCount, length, imageUrl);
      albumRepository.save(m);
      return new RedirectView("/albums");
    }
  }
