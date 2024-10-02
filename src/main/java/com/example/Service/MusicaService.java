package com.example.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Musica;
import com.example.Repository.MusicaRepository;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public List<Musica> obterTodas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> obterPelaId(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica incluir(Musica musica) {
        musica.setId(0L); // Reset id to ensure new music is created
        return musicaRepository.save(musica);
    }

    public Musica atualizar(Musica musica) {
        Musica antiga = musicaRepository.findById(musica.getId()).orElse(null);
        if (antiga == null) {
            throw new RuntimeException("Música não encontrada");
        }
        antiga.setTitulo(musica.getTitulo());
        antiga.setArtista(musica.getArtista());
        antiga.setAlbum(musica.getAlbum());
        return musicaRepository.save(antiga);
    }

    public void excluir(Long id) {
        musicaRepository.deleteById(id);
    }
}
