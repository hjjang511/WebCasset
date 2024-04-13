package vn.edu.huce.ltudm.cassette.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.Cassette;
import vn.edu.huce.ltudm.cassette.Repository.CassetteRepository;

@Service
public class CassetteService {
    @Autowired
    CassetteRepository CassetteRepo;

    public Cassette getCassettebyId(int id) {
        return CassetteRepo.findById(id).get();
    }

    public void createCassette(Cassette Cassette) {
        CassetteRepo.save(Cassette);
    }

    public void updateCassette(int id, Cassette Cassette) {
        Cassette.setId(id);
        CassetteRepo.save(Cassette);
    }

    public void deleteCassette(int id) {
        CassetteRepo.deleteById(id);
    }

    public Collection<Cassette> getCassettes() {
        return CassetteRepo.findAll();
    }
}
