package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Musica;
import com.example.Entity.Playlist;
import com.example.Repository.PlaylistRepository;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> obterTodos() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> obterPeloId(Long id) {
        return playlistRepository.findById(id);
    }

    public Playlist incluir(Playlist playlist) {
        playlist.setId(0L); // Resetar ID para garantir que uma nova playlist seja criada
        return playlistRepository.save(playlist);
    }

    public Playlist atualizar(Playlist playlist) {
        Playlist antiga = playlistRepository.findById(playlist.getId()).orElse(null);
        if (antiga == null) {
            throw new RuntimeException("Playlist não encontrada");
        }
        antiga.setNomePlaylist(playlist.getNomePlaylist());
        antiga.setUsuario(playlist.getUsuario());
        antiga.setMusicas(playlist.getMusicas());
        return playlistRepository.save(antiga);
    }

    public void excluir(Long id) {
        playlistRepository.deleteById(id);
    }

    // Método para adicionar música à playlist
    public Playlist adicionarMusica(Long playlistId, Musica musica) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> 
            new RuntimeException("Playlist não encontrada")
        );
        playlist.getMusicas().add(musica); // Adiciona a música à lista
        return playlistRepository.save(playlist); // Salva a playlist atualizada
    }
}
