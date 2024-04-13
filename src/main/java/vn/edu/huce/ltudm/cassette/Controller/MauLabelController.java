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

import vn.edu.huce.ltudm.cassette.Entity.MauLabel;
import vn.edu.huce.ltudm.cassette.Service.MauLabelService;

@RestController
@RequestMapping("/MauLabel")
public class MauLabelController {
    @Autowired
    private MauLabelService MauLabelService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public MauLabel getMauLabelById(@PathVariable int id) {
        return MauLabelService.getMauLabelbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody MauLabel MauLabel) {
        MauLabelService.createMauLabel(MauLabel);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody MauLabel MauLabel) {
        MauLabelService.updateMauLabel(id, MauLabel);
    }

    // Xóa một đối tượng ExampleEntity theo id
    @DeleteMapping("/{id}")
    public void deleteMauLabel(@PathVariable int id) {
        MauLabelService.deleteMauLabel(id);
    }


}
