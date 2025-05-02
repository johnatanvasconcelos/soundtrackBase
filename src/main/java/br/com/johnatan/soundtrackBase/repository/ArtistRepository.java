package br.com.johnatan.soundtrackBase.repository;

import br.com.johnatan.soundtrackBase.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByNameContainingIgnoreCase(String name);
}
