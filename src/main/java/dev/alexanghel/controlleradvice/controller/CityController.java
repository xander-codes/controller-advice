package dev.alexanghel.controlleradvice.controller;

import dev.alexanghel.controlleradvice.model.City;
import dev.alexanghel.controlleradvice.service.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping(value = "/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping
    public City createCity(@RequestBody @Valid City city) {
        return cityService.save(city);
    }
}
