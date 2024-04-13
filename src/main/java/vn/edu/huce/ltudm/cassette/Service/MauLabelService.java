package vn.edu.huce.ltudm.cassette.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.MauLabel;
import vn.edu.huce.ltudm.cassette.Repository.MauLabelRepository;

@Service
public class MauLabelService {
    @Autowired
    MauLabelRepository MauLabelRepo;

    public MauLabel getMauLabelbyId(int id) {
        return MauLabelRepo.findById(id).get();
    }

    public MauLabel getMauLabelByName(String name) {
        return MauLabelRepo.findByName(name);
    }

    public void createMauLabel(MauLabel MauLabel) {
        MauLabelRepo.save(MauLabel);
    }

    public void updateMauLabel(int id, MauLabel MauLabel) {
        MauLabel.setId(id);
        MauLabelRepo.save(MauLabel);
    }

    public void deleteMauLabel(int id) {
        MauLabelRepo.deleteById(id);
    }

    public Collection<MauLabel> getMauLabels() {
        return MauLabelRepo.findAll();
    }
}
