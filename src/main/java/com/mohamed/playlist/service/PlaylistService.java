package com.mohamed.playlist.service;

import com.mohamed.playlist.entity.Playlist;
import com.mohamed.playlist.entity.Song;

import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    List<Playlist> getPlaylistsByUserId(Long userId);
    Playlist addSongToPlaylist(Long playlistId, Long songId);
    Playlist getPlaylistById(Long playlistId);
    Playlist updatePlaylist(Long id, Playlist playlist);
    void deletePlaylist(Long id);
}