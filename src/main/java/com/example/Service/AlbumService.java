package com.example.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Album;
import com.example.Repository.AlbumRepository;
@Service
public class AlbumService {
      @Autowired
    private AlbumRepository albumRepository;

    public List<Album> obterTodos() {
        return albumRepository.findAll();
    }

    public Optional<Album> obterPeloId(Long id) {
        return albumRepository.findById(id);
    }

    public Album incluir(Album album) {
        album.setId(0L); // Reset id to ensure new album is created
        return albumRepository.save(album);
    }

    public Album atualizar(Album album) {
        Album antigo = albumRepository.findById(album.getId()).orElse(null);
        if (antigo == null) {
            throw new RuntimeException("Álbum não encontrado");
        }
        antigo.setNomeAlbum(album.getNomeAlbum());
        antigo.setArtista(album.getArtista());
        return albumRepository.save(antigo);
    }

    public void excluir(Long id) {
        albumRepository.deleteById(id);
    }
}
