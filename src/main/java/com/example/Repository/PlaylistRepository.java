package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Playlist;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    
}
