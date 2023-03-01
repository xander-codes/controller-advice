package dev.alexanghel.controlleradvice;

import dev.alexanghel.controlleradvice.model.City;
import dev.alexanghel.controlleradvice.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ControllerAdviceApplication implements CommandLineRunner {

    public ControllerAdviceApplication(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ControllerAdviceApplication.class, args);
    }

    private final CityRepository cityRepository;

    @Override
    public void run(String... args) {

        log.info("Saving cities");

        cityRepository.save(new City("Bratislava", 432000, 100, "default@email.com"));
        cityRepository.save(new City("Budapest", 1759000, 100, "default@email.com"));
        cityRepository.save(new City("Prague", 1280000, 100, "default@email.com"));
        cityRepository.save(new City("Warsaw", 1748000, 100, "default@email.com"));
        cityRepository.save(new City("Los Angeles", 3971000, 100, "default@email.com"));
        cityRepository.save(new City("New York", 8550000, 100, "default@email.com"));
        cityRepository.save(new City("Edinburgh", 464000, 100, "default@email.com"));
        cityRepository.save(new City("Suzhou", 4327066, 100, "default@email.com"));
        cityRepository.save(new City("Zhengzhou", 4122087, 100, "default@email.com"));
        cityRepository.save(new City("Berlin", 3671000, 100, "default@email.com"));
    }
}
