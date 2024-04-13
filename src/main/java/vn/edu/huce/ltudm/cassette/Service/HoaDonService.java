package vn.edu.huce.ltudm.cassette.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.HoaDon;
import vn.edu.huce.ltudm.cassette.Repository.HoaDonRepository;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository HoaDonRepo;

    public HoaDon getHoaDonbyId(int id) {
        return HoaDonRepo.findById(id).get();
    }

    public HoaDon getHoaDonByName(String name) {
        return HoaDonRepo.findByName(name);
    }

    public void createHoaDon(HoaDon HoaDon) {
        HoaDonRepo.save(HoaDon);
    }

    public void updateHoaDon(int id, HoaDon HoaDon) {
        HoaDon.setId(id);
        HoaDonRepo.save(HoaDon);
    }

    public void deleteHoaDon(int id) {
        HoaDonRepo.deleteById(id);
    }

    public Collection<HoaDon> getHoaDons() {
        return HoaDonRepo.findAll();
    }
}
