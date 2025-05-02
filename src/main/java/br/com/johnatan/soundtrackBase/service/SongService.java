package br.com.johnatan.soundtrackBase.service;

import br.com.johnatan.soundtrackBase.dto.SongDTO;
import br.com.johnatan.soundtrackBase.mapper.ArtistMapper;
import br.com.johnatan.soundtrackBase.mapper.SongMapper;
import br.com.johnatan.soundtrackBase.models.Artist;
import br.com.johnatan.soundtrackBase.models.Song;
import br.com.johnatan.soundtrackBase.repository.ArtistRepository;
import br.com.johnatan.soundtrackBase.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<SongDTO> getAllSongs() {
        return songRepository.findAll()
                .stream()
                .map(SongMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Song createSong(SongDTO songDTO) {
        Artist artist = artistRepository.findById(songDTO.artistId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));

        Song song = SongMapper.toEntity(songDTO, artist);
        return songRepository.save(song);
    }

    public List<SongDTO> searchSongsByArtistName(String nameArtist) {
        return songRepository.findByArtistNameContainingIgnoreCase(nameArtist)
                .stream()
                .map(SongMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<SongDTO> searchSongsByYear(int year) {
        return songRepository.findByYearLaunchGreaterThanEqual(year)
                .stream()
                .map(SongMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<SongDTO> findSongsByArtistId(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));

        return artist.getSongs().stream()
                .map(SongMapper::toDTO)
                .toList();
    }
}
