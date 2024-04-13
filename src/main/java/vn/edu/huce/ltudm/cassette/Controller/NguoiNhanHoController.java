package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.huce.ltudm.cassette.Entity.NguoiNhanHo;
import vn.edu.huce.ltudm.cassette.Service.NguoiNhanHoService;

@RestController
@RequestMapping("/NguoiNhanHo")
public class NguoiNhanHoController {
    @Autowired
    private NguoiNhanHoService NguoiNhanHoService;

    // Xem một đối tượng ExampleEntity theo id
    @GetMapping("/{id}")
    public NguoiNhanHo getNguoiNhanHoById(@PathVariable int id) {
        return NguoiNhanHoService.getNguoiNhanHobyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody NguoiNhanHo NguoiNhanHo) {
        NguoiNhanHoService.createNguoiNhanHo(NguoiNhanHo);
    }

}
