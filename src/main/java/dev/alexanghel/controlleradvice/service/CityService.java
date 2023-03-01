package dev.alexanghel.controlleradvice.service;

import dev.alexanghel.controlleradvice.exception.CityNotFoundException;
import dev.alexanghel.controlleradvice.exception.NoDataFoundException;
import dev.alexanghel.controlleradvice.model.City;
import dev.alexanghel.controlleradvice.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public List<City> findAll() {
        List<City> cities = (List<City>) cityRepository.findAll();
        if (cities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return cities;
    }
}
