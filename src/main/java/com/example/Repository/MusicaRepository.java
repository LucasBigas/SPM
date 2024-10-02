package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Musica;
@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    
}
