package com.example.journey_through_health.image;

import com.example.journey_through_health.image.Image;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {


    @PostMapping()
    public void addImage(@RequestBody Image newImage) {
        System.out.println("Image added");
    }

    @PutMapping("/${id}")
    public void editImage(@RequestBody Image newImage,@PathVariable Long id) {
        System.out.println("Image edited");
    }

    @DeleteMapping ("/{id}")
    public void deleteImage(@PathVariable Long id) {
        System.out.println("Image deleted");
    }
}
