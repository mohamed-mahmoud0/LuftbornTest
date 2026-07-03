package com.mohamed.playlist.controller;
import com.mohamed.playlist.entity.Playlist;
import com.mohamed.playlist.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist created = playlistService.createPlaylist(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getPlaylists(@RequestParam Long userId) {
        List<Playlist> playlists = playlistService.getPlaylistsByUserId(userId);
        return ResponseEntity.ok(playlists);
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        Playlist updated = playlistService.addSongToPlaylist(playlistId, songId);
        return ResponseEntity.ok(updated);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Playlist> getPlaylist(@PathVariable Long id) {
        Playlist playlist = playlistService.getPlaylistById(id);
        return ResponseEntity.ok(playlist);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.updatePlaylist(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}