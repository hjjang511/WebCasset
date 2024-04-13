package vn.edu.huce.ltudm.cassette.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.MauBang;
import vn.edu.huce.ltudm.cassette.Repository.MauBangRepository;

@Service
public class MauBangService {
    @Autowired
    MauBangRepository MauBangRepo;

    public MauBang getMauBangbyId(int id) {
        return MauBangRepo.findById(id).get();
    }

    public MauBang getMauBangByName(String name) {
        return MauBangRepo.findByName(name);
    }

    public void createMauBang(MauBang MauBang) {
        MauBangRepo.save(MauBang);
    }

    public void updateMauBang(int id, MauBang MauBang) {
        MauBang.setId(id);
        MauBangRepo.save(MauBang);
    }

    public void deleteMauBang(int id) {
        MauBangRepo.deleteById(id);
    }

    public Collection<MauBang> getMauBangs() {
        return MauBangRepo.findAll();
    }
}
