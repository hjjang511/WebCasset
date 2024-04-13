package vn.edu.huce.ltudm.cassette.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import vn.edu.huce.ltudm.cassette.Service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            imageService.uploadImage(file);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file!";
        }
    }

    @GetMapping("/download/{id}")
    public byte[] downloadImage(@PathVariable int id) {
        try {
            return imageService.downloadImage(id);
        } catch (IOException e) {
            throw new RuntimeException("Error downloading file!");
        }
    }
}
