package com.madscientistlaboratories.songr.controllers;


import com.madscientistlaboratories.songr.models.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.sql.Date;

@Controller
public class MovieController {

@GetMapping("/movies")
  public String getAllMovies(Model m){
//  String title, String director, Date releaseDate, double rottenTomatoesScore, String mpaaRating
  Movie theMovie= new Movie("some move", "somebody", Date.valueOf("1994-01-17"), 72, "PG-13" );

  Movie secondMovie= new Movie("some other move", "another director", Date.valueOf("1994-01-17"), 72, "PG-13" );

  Movie[] movies = new Movie[]{theMovie, secondMovie};
  m.addAttribute(movies);
  return "allMovies";

}

}
