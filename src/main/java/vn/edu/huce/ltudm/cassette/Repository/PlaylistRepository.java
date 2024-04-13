package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
    @Query(value = "SELECT * FROM Playlist WHERE name = ?1", nativeQuery = true)
    Playlist findByName(String name);
}
