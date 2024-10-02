package com.example.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Artista;
import com.example.Entity.Musica;
import com.example.Entity.Usuario;
import com.example.Repository.UsuarioRepository;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obterTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obterPeloId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario incluir(Usuario usuario) {
        usuario.setId(0); // Reset id to ensure new user is created
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        Usuario antiga = usuarioRepository.findById(usuario.getId()).orElse(null);
        if (antiga == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        antiga.setNome(usuario.getNome());
        antiga.setEmail(usuario.getEmail());
        antiga.setSenha(usuario.getSenha());
        return usuarioRepository.save(antiga);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario adicionarArtista(Long usuarioId, Artista artista) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> 
            new RuntimeException("Usuário não encontrado")
        );
        usuario.getArtistas().add(artista); // Adiciona o artista à lista
        return usuarioRepository.save(usuario); // Salva o usuário atualizado
    }

    // Método para adicionar música ao usuário
    public Usuario adicionarMusica(Long usuarioId, Musica musica) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> 
            new RuntimeException("Usuário não encontrado")
        );
        usuario.getMusicas().add(musica); // Adiciona a música à lista
        return usuarioRepository.save(usuario); // Salva o usuário atualizado
    }
}
