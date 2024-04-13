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

import vn.edu.huce.ltudm.cassette.Entity.MauBang;
import vn.edu.huce.ltudm.cassette.Service.MauBangService;

@RestController
@RequestMapping("/MauBang")
public class MauBangController {
    @Autowired
    private MauBangService mauBangService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public MauBang getMauBangById(@PathVariable int id) {
        return mauBangService.getMauBangbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody MauBang mauBang) {
        mauBangService.createMauBang(mauBang);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody MauBang mauBang) {
        mauBangService.updateMauBang(id, mauBang);
    }

    // Xóa một đối tượng ExampleEntity theo id
    @DeleteMapping("/{id}")
    public void deleteMauBang(@PathVariable int id) {
        mauBangService.deleteMauBang(id);
    }


}
