package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.MauLabel;

@Repository
public interface MauLabelRepository extends JpaRepository<MauLabel, Integer> {
    @Query(value = "SELECT * FROM MauLabel WHERE name = ?1", nativeQuery = true)
    MauLabel findByName(String name);
}
