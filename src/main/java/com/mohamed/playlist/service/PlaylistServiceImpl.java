package com.mohamed.playlist.service;

import com.mohamed.playlist.entity.Playlist;
import com.mohamed.playlist.entity.Song;
import com.mohamed.playlist.repository.PlaylistRepository;
import com.mohamed.playlist.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getPlaylistsByUserId(Long userId) {
        return playlistRepository.findByUserId(userId);
    }

    @Override
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);
    }
    @Override
    public Playlist getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }
    @Override
    public Playlist updatePlaylist(Long id, Playlist updatedPlaylist) {
        Playlist existing = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        existing.setName(updatedPlaylist.getName());
        return playlistRepository.save(existing);
    }

    @Override
    public void deletePlaylist(Long id){
        playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlistRepository.deleteById(id);
    }

}