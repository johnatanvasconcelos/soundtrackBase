package br.com.johnatan.soundtrackBase.controller;

import br.com.johnatan.soundtrackBase.dto.SongDTO;
import br.com.johnatan.soundtrackBase.models.Song;
import br.com.johnatan.soundtrackBase.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<SongDTO> getAllSongs() {
        return songService.getAllSongs();
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody SongDTO songDTO) {
        Song createdSong = songService.createSong(songDTO);
        return ResponseEntity.status(201).body(createdSong);
    }

    @GetMapping("/search")
    public List<SongDTO> searchSongsByArtistName(@RequestParam("nameArtist") String nameArtist) {
        return songService.searchSongsByArtistName(nameArtist);
    }

    @GetMapping("/artists/{id}/songs")
    public List<SongDTO> getSongsByArtistId(@PathVariable Long id) {
        return songService.findSongsByArtistId(id);
    }

    @GetMapping("/search/year")
    public List<SongDTO> searchSongsByYear(@RequestParam int year) {
        return songService.searchSongsByYear(year);
    }
}

