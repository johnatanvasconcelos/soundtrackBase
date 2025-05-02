package br.com.johnatan.soundtrackBase.service;

import br.com.johnatan.soundtrackBase.dto.ArtistDTO;
import br.com.johnatan.soundtrackBase.mapper.ArtistMapper;
import br.com.johnatan.soundtrackBase.models.Artist;
import br.com.johnatan.soundtrackBase.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<ArtistDTO> getAllArtists() {
        return artistRepository.findAll()
                .stream()
                .map(ArtistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ArtistDTO> getArtistById(Long id) {
        return artistRepository.findById(id)
                .map(ArtistMapper::toDTO);
    }

    public Artist createArtist(ArtistDTO artistDTO) {
        Artist artist = ArtistMapper.toEntity(artistDTO);
        return artistRepository.save(artist);
    }

    public List<ArtistDTO> searchArtistsByName(String name) {
        return artistRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(ArtistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteArtist(Long id){
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artista não encontrado"));
        artistRepository.delete(artist);
    }
}

