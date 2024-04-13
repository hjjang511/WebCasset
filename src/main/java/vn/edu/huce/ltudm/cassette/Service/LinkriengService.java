package vn.edu.huce.ltudm.cassette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.Linkrieng;
import vn.edu.huce.ltudm.cassette.Repository.LinkriengRepository;

@Service
public class LinkriengService {
    @Autowired
    LinkriengRepository LinkriengRepo;

    public Linkrieng getLinkriengbyId(int id) {
        return LinkriengRepo.findById(id).get();
    }

    public void createLinkrieng(Linkrieng Linkrieng) {
        LinkriengRepo.save(Linkrieng);
    }
}
