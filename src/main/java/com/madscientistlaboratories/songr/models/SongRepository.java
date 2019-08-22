package com.madscientistlaboratories.songr.models;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    public Song findByTitleAndAlbum(String title, Album album);
    public Song findByTitle(String title);
}
