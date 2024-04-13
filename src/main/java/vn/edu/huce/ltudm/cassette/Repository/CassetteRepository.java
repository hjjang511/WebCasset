package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.Cassette;

@Repository
public interface CassetteRepository extends JpaRepository<Cassette, Integer> {

}
