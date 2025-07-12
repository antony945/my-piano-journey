package com.github.antony945.my_piano_journey_backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final List<Song> songsList = new ArrayList<>();

    public SongService() {
        songsList.add(new Song(1, "Die For You"));
        songsList.add(new Song(2, "Call Out My Name"));
    }

    public List<Song> getAllSongs() {
        return songsList;
    }

    public Song getSongById(int id) {
        return songsList.stream()
            .filter(song -> song.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public Song createSong(Song song) {
        songsList.add(song);
        return song;
    }

}
