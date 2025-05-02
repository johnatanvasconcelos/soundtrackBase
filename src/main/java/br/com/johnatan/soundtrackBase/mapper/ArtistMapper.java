package br.com.johnatan.soundtrackBase.mapper;

import br.com.johnatan.soundtrackBase.dto.ArtistDTO;
import br.com.johnatan.soundtrackBase.models.Artist;

public class ArtistMapper {

    // DTO → Entity
    public static Artist toEntity(ArtistDTO dto) {
        Artist artist = new Artist();
        artist.setName(dto.name());
        artist.setMusicalGenre(dto.musicalGenre());
        artist.setCountry(dto.country());
        return artist;
    }

    // Entity → DTO
    public static ArtistDTO toDTO(Artist artist) {
        return new ArtistDTO(
                artist.getId(),
                artist.getName(),
                artist.getMusicalGenre(),
                artist.getCountry()
        );
    }
}
