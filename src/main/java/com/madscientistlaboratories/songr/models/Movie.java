package com.madscientistlaboratories.songr.models;

import jdk.jfr.events.CertificateId;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      long Id;
  String title;
  String director;
  Date releaseDate;
  double rottenTomatoesScore;
  String mpaaRating;

  public Movie(String title, String director, Date releaseDate, double rottenTomatoesScore, String mpaaRating){
    this.title = title;
    this.director = director;
    this.releaseDate = releaseDate;
    this.rottenTomatoesScore = rottenTomatoesScore;
    this.mpaaRating = mpaaRating;
  }


  public String getTitle() {
    return title;
  }
}