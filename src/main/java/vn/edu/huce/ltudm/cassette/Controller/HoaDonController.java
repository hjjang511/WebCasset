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

import vn.edu.huce.ltudm.cassette.Entity.HoaDon;
import vn.edu.huce.ltudm.cassette.Service.HoaDonService;

@RestController
@RequestMapping("/HoaDon")
public class HoaDonController {
    @Autowired
    private HoaDonService HoaDonService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public HoaDon getHoaDonById(@PathVariable int id) {
        return HoaDonService.getHoaDonbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody HoaDon HoaDon) {
        HoaDonService.createHoaDon(HoaDon);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody HoaDon HoaDon) {
        HoaDonService.updateHoaDon(id, HoaDon);
    }

    // Xóa một đối tượng ExampleEntity theo id
    @DeleteMapping("/{id}")
    public void deleteHoaDon(@PathVariable int id) {
        HoaDonService.deleteHoaDon(id);
    }


}
