package com.clickbus.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickbus.test.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
  public List<Place> findByNameContains(String name);
}
