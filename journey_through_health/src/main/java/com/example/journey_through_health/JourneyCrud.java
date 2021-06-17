package com.example.journey_through_health;

import java.util.List;
import java.util.Optional;

public interface JourneyCrud<T> {
    T create(T o);
    T edit(Long id, T o);
    Optional<T> get(Long id);
    Optional<T> delete(Long id);
    List<T> listAll();
}
