package br.com.johnatan.soundtrackBase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration;

    private Integer yearLaunch;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnore
    private Artist artist;

}
