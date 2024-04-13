package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.huce.ltudm.cassette.Entity.Playlist;
import vn.edu.huce.ltudm.cassette.Service.PlaylistService;

@RestController
@RequestMapping("/Playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService PlaylistService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable int id) {
        return PlaylistService.getPlaylistbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Playlist Playlist) {
        PlaylistService.createPlaylist(Playlist);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody Playlist Playlist) {
        PlaylistService.updatePlaylist(id, Playlist);
    }

    // Xóa một đối tượng ExampleEntity theo id
    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable int id) {
        PlaylistService.deletePlaylist(id);
    }


}
