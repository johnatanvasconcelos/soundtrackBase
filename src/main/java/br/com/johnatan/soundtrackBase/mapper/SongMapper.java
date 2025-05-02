package br.com.johnatan.soundtrackBase.mapper;

import br.com.johnatan.soundtrackBase.dto.SongDTO;
import br.com.johnatan.soundtrackBase.models.Artist;
import br.com.johnatan.soundtrackBase.models.Song;

public class SongMapper {
    //DTO → Entity
    public static Song toEntity(SongDTO dto, Artist artist) {
        Song song = new Song();
        song.setTitle(dto.title());
        song.setDuration(dto.duration());
        song.setYearLaunch(dto.yearLaunch());
        song.setArtist(artist);
        return song;
    }

    // Entity → DTO
    public static SongDTO toDTO(Song song) {
        return new SongDTO(
                song.getId(),
                song.getTitle(),
                song.getDuration(),
                song.getYearLaunch(),
                song.getArtist().getId()
        );
    }

}
