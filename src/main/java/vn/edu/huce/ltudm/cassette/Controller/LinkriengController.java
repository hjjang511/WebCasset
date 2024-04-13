package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.huce.ltudm.cassette.Entity.Linkrieng;
import vn.edu.huce.ltudm.cassette.Service.LinkriengService;

@RestController
@RequestMapping("/Linkrieng")
public class LinkriengController {
    @Autowired
    private LinkriengService LinkriengService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public Linkrieng getLinkriengById(@PathVariable int id) {
        return LinkriengService.getLinkriengbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Linkrieng Linkrieng) {
        LinkriengService.createLinkrieng(Linkrieng);
    }

}
