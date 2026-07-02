package com.mohamed.playlist.controller;
import com.mohamed.playlist.entity.Song;
import com.mohamed.playlist.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService=songService;
    }
    @PostMapping
    public ResponseEntity<Song>  createSong(@RequestBody Song song) {
        return ResponseEntity.status(HttpStatus.CREATED).body(songService.createSong(song));
    }
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.status(HttpStatus.OK).body(songService.getAllSongs());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

}
