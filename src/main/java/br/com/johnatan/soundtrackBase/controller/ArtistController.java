package br.com.johnatan.soundtrackBase.controller;

import br.com.johnatan.soundtrackBase.dto.ArtistDTO;
import br.com.johnatan.soundtrackBase.models.Artist;
import br.com.johnatan.soundtrackBase.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<ArtistDTO> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long id) {
        Optional<ArtistDTO> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody ArtistDTO artistDTO) {
        Artist createdArtist = artistService.createArtist(artistDTO);
        return ResponseEntity.status(201).body(createdArtist);
    }

    @GetMapping("/search")
    public List<ArtistDTO> searchArtists(@RequestParam String name) {
        return artistService.searchArtistsByName(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }
}

