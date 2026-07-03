package com.mohamed.playlist.service;

import com.mohamed.playlist.entity.Song;
import com.mohamed.playlist.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
    }
    @Override
    public Song updateSong(Long id, Song updatedSong) {
        Song existing = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        existing.setTitle(updatedSong.getTitle());
        existing.setArtist(updatedSong.getArtist());
        return songRepository.save(existing);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        songRepository.deleteById(id);
    }
}