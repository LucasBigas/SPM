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

import com.example.Entity.Album;
import com.example.Service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
     @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> obterTodos() {
        return albumService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> obterPeloId(@PathVariable Long id) {
        var opt = albumService.obterPeloId(id);
        return opt.map(album -> new ResponseEntity<>(album, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Album> incluir(@RequestBody Album album) {
        album = albumService.incluir(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Album> atualizar(@RequestBody Album album) {
        try {
            album = albumService.atualizar(album);
            return new ResponseEntity<>(album, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            albumService.excluir(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
