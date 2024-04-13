package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.huce.ltudm.cassette.Entity.Cassette;
import vn.edu.huce.ltudm.cassette.Service.CassetteService;

@RestController
@RequestMapping("/Cassette")
public class CassetteController {
    @Autowired
    private CassetteService CassetteService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public Cassette getCassetteById(@PathVariable int id) {
        return CassetteService.getCassettebyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Cassette Cassette) {
        CassetteService.createCassette(Cassette);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody Cassette Cassette) {
        CassetteService.updateCassette(id, Cassette);
    }

    // Xóa một đối tượng ExampleEntity theo id
    @DeleteMapping("/{id}")
    public void deleteCassette(@PathVariable int id) {
        CassetteService.deleteCassette(id);
    }


}
