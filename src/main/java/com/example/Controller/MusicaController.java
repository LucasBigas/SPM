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

import com.example.Entity.Musica;
import com.example.Service.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public List<Musica> obterTodas() {
        return musicaService.obterTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> obterPeloId(@PathVariable Long id) {
        var opt = musicaService.obterPelaId(id);
        return opt.map(musica -> new ResponseEntity<>(musica, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Musica> incluir(@RequestBody Musica musica) {
        musica = musicaService.incluir(musica);
        return new ResponseEntity<>(musica, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Musica> atualizar(@RequestBody Musica musica) {
        try {
            musica = musicaService.atualizar(musica);
            return new ResponseEntity<>(musica, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            musicaService.excluir(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
