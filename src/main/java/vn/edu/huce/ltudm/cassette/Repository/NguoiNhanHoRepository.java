package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.NguoiNhanHo;

@Repository
public interface NguoiNhanHoRepository extends JpaRepository<NguoiNhanHo, Integer> {

}
