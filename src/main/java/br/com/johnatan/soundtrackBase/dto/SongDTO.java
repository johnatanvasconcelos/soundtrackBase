package br.com.johnatan.soundtrackBase.dto;

public record SongDTO (Long id,
                       String title,
                       Integer duration,
                       Integer yearLaunch,
                       Long artistId) {

}
