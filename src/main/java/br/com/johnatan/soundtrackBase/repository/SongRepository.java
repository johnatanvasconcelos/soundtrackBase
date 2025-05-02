package br.com.johnatan.soundtrackBase.repository;

import br.com.johnatan.soundtrackBase.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByArtistNameContainingIgnoreCase(String nameArtist);
    List<Song> findByYearLaunchGreaterThanEqual(int year);
}
