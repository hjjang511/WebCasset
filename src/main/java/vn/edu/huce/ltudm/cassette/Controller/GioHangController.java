package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.huce.ltudm.cassette.Entity.GioHang;
import vn.edu.huce.ltudm.cassette.Service.GioHangService;

@RestController
@RequestMapping("/GioHang")
public class GioHangController {
    @Autowired
    private GioHangService GioHangService;
    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public GioHang getGioHangById(@PathVariable int id) {
        return GioHangService.getGioHangbyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody GioHang GioHang) {
        GioHangService.createGioHang(GioHang);
    }

}
