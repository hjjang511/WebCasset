package vn.edu.huce.ltudm.cassette.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.Playlist;
import vn.edu.huce.ltudm.cassette.Repository.PlaylistRepository;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepo;

    public Playlist getPlaylistbyId(int id) {
        return playlistRepo.findById(id).get();
    }

    public Playlist getPlaylistByName(String name) {
        return playlistRepo.findByName(name);
    }

    public void createPlaylist(Playlist playlist) {
        playlistRepo.save(playlist);
    }

    public void updatePlaylist(int id, Playlist playlist) {
        playlist.setId(id);
        playlistRepo.save(playlist);
    }

    public void deletePlaylist(int id) {
        playlistRepo.deleteById(id);
    }

    public Collection<Playlist> getPlaylists() {
        return playlistRepo.findAll();
    }
}
