package vn.edu.huce.ltudm.cassette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.GioHang;
import vn.edu.huce.ltudm.cassette.Repository.GioHangRepository;

@Service
public class GioHangService {
    @Autowired
    GioHangRepository GioHangRepo;

    public GioHang getGioHangbyId(int id) {
        return GioHangRepo.findById(id).get();
    }

    public void createGioHang(GioHang GioHang) {
        GioHangRepo.save(GioHang);
    }

}
