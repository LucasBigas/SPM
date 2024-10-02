package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Artista;
import com.example.Entity.Musica;
import com.example.Entity.Usuario;
import com.example.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obterTodos() {
        return usuarioService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterPeloId(@PathVariable Long id) {
        var opt = usuarioService.obterPeloId(id);
        return opt.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Usuario> incluir(@RequestBody Usuario usuario) {
        usuario = usuarioService.incluir(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        try {
            usuario = usuarioService.atualizar(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            usuarioService.excluir(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{usuarioId}/artista")
    public ResponseEntity<Void> adicionarArtista(@PathVariable Long usuarioId, @RequestBody Artista artista) {
        usuarioService.adicionarArtista(usuarioId, artista);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{usuarioId}/musica")
    public ResponseEntity<Void> adicionarMusica(@PathVariable Long usuarioId, @RequestBody Musica musica) {
        usuarioService.adicionarMusica(usuarioId, musica);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}   
