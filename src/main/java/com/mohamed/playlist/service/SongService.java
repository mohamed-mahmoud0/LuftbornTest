package com.mohamed.playlist.service;

import com.mohamed.playlist.entity.Song;
import java.util.List;

public interface SongService {
    Song createSong(Song song);
    List<Song> getAllSongs();
    Song getSongById(Long id);
}