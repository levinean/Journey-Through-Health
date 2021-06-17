package com.example.journey_through_health.image;

import com.example.journey_through_health.JourneyCrud;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements JourneyCrud<Image> {

    private final ImageRepository imageRepo;

    public ImageService(ImageRepository imageRepo) {
        this.imageRepo = imageRepo;
    }

    public Image create(Image image) {
        image.setCreatedAt(Instant.now());
        return imageRepo.save(image);
    }

    @Override
    public Image edit(Long id, Image o) {
        return null;
    }

    @Override
    public Optional<Image> get(Long id) {
        return Optional.empty();
    }

    public Optional<Image> delete(Long id) {
        Optional<Image> image = imageRepo.findById(id);
        imageRepo.deleteById(id);
        return image;
    }

    @Override
    public List<Image> listAll() {
        return new ArrayList<>();
    }

}
