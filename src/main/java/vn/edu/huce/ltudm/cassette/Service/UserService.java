package vn.edu.huce.ltudm.cassette.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.huce.ltudm.cassette.Entity.User;
import vn.edu.huce.ltudm.cassette.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public User getUserbyName(String name) {
        return userRepo.findByName(name);
    }

    public User getUserbyId(int id) {
        return userRepo.findById(id).get();
    }

    public void updateUser(int id, User user) {
        user.setId(id);
        userRepo.save(user);
    }

}
