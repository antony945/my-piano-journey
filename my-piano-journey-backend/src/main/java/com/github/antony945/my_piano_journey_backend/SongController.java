package com.github.antony945.my_piano_journey_backend;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok().body(songService.getAllSongs());
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<?> getSongById(@PathVariable int id) {
        Song song = songService.getSongById(id);
        if (song == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(song);
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> postNewSong(@RequestBody Song song) {
        Song createdSong = songService.createSong(song);
        if (createdSong == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdSong);
    }    
    
    
}
