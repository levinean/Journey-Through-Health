package com.example.journey_through_health.image;

import com.example.journey_through_health.image.Image;
import com.example.journey_through_health.image.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepo;

    public Image addImage(Image newImage) {
        Image image = imageRepo.save(newImage);
        return image;
    }

    public Image deleteImage(Long imageId) throws Exception {
        Optional<Image> image = imageRepo.findById(imageId);
        if (image.isEmpty()) {
            throw new Exception(String.format("No image with the id %d", imageId));
        }
        imageRepo.deleteById(imageId);
        return image.get();
    }

    public Image editImage(Long imageId, Image newImage) throws Exception {
        Optional<Image> image = imageRepo.findById(imageId);
        if (image.isEmpty()) {
            throw new Exception(String.format("No image with the id %d", imageId));
        }
        imageRepo.deleteById(imageId);
        Image savedImage = imageRepo.save(newImage);
        return savedImage;
    }
}
