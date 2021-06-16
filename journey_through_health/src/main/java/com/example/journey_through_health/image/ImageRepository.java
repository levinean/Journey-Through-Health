package com.example.journey_through_health.image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByEventId(Long eventId);
}
