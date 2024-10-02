package com.example.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAlbum;
    @OneToMany(mappedBy = "album")
    private List<Musica> musicas;
    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;
}
