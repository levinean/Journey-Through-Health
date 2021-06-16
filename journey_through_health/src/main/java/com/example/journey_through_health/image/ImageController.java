package com.example.journey_through_health.image;

import com.example.journey_through_health.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService service;

    @PostMapping()
    public Image addImage(@RequestBody Image newImage) {
        return service.addImage(newImage);
    }

    @PutMapping("/{id}")
    public Image editImage(@RequestBody Image newImage, @PathVariable Long id) throws Exception {
        return service.editImage(id, newImage);
    }

    @DeleteMapping("/{id}")
    public Image deleteImage(@PathVariable Long id) throws Exception {
        return service.deleteImage(id);
    }
}
