package vn.edu.huce.ltudm.cassette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.NguoiNhanHo;
import vn.edu.huce.ltudm.cassette.Repository.NguoiNhanHoRepository;

@Service
public class NguoiNhanHoService {
    @Autowired
    NguoiNhanHoRepository NguoiNhanHoRepo;

    public NguoiNhanHo getNguoiNhanHobyId(int id) {
        return NguoiNhanHoRepo.findById(id).get();
    }

    public void createNguoiNhanHo(NguoiNhanHo nguoiNhanHo) {
        NguoiNhanHoRepo.save(nguoiNhanHo);
    }
}
