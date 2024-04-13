package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    @Query(value = "SELECT * FROM HoaDon WHERE name = ?1", nativeQuery = true)
    HoaDon findByName(String name);
}
