package com.example.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Artista;
@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    
}
