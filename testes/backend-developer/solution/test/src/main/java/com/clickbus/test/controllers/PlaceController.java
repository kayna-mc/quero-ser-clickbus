package com.clickbus.test.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clickbus.test.PlaceRepository;
import com.clickbus.test.exceptions.PlaceNotFoundException;
import com.clickbus.test.models.Place;

@RestController
public class PlaceController {

  private final PlaceRepository repo;

  public PlaceController(PlaceRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/places")
  public List<Place> getAllPlaces() {
    return repo.findAll();
  }

  @GetMapping("/placesByName/{name}")
  public List<Place> getPlacesByName(@PathVariable String name) {
    return repo.findByNameContains(name);
  }

  @GetMapping("/places/{id}")
  public Place getPlace(@PathVariable Long id) {
    return repo.findById(id).orElseThrow(() -> new PlaceNotFoundException("The id '" + id + "' doesn't exists"));
  }

  @PostMapping("/places")
  public Place newPlace(@RequestBody Place newPlace) {
    return repo.save(newPlace);
  }

  @PutMapping("/places/{id}")
  public Place replacePlace(@RequestBody Place updatedPlace, @PathVariable Long id) {
    return repo.findById(id).map(place -> {
      place.setName(updatedPlace.getName());
      place.setSlug(updatedPlace.getSlug());
      place.setCity(updatedPlace.getCity());
      place.setState(updatedPlace.getState());
      return repo.save(place);
    }).orElseThrow(() -> new PlaceNotFoundException("Can't update. The id '" + id + "' doesn't exists"));
  }
}
