package com.github.antony945.my_piano_journey_backend;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SongService {
    // private final List<Song> songsList = new ArrayList<>();
    private final SongRepository songRepository;

    // public SongService() {
        // songsList.add(new Song(1, "Die For You"));
        // songsList.add(new Song(2, "Call Out My Name"));
    // }

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(int id) {
        // return songsList.stream()
        //     .filter(song -> song.getId() == id)
        //     .findFirst()
        //     .orElse(null);
        return songRepository.findById(id).orElseThrow();
    }

    public Song createSong(Song song) {
        // songsList.add(song);
        songRepository.save(song);    
        return song;
    }

}
