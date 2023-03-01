package dev.alexanghel.controlleradvice.controller;

import dev.alexanghel.controlleradvice.model.City;
import dev.alexanghel.controlleradvice.service.CityService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping(value = "/cities"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public City createCity(@RequestBody @Valid City city) {
        return cityService.save(city);
    }

    @GetMapping(value = "/cities")
    public List<City> findAll() {
        return cityService.findAll();
    }
}
