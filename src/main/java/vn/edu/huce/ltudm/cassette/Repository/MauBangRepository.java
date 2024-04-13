package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.MauBang;

@Repository
public interface MauBangRepository extends JpaRepository<MauBang, Integer> {
    @Query(value = "SELECT * FROM MauBang WHERE name = ?1", nativeQuery = true)
    MauBang findByName(String name);
}
