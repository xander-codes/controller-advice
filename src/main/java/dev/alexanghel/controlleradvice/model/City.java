package dev.alexanghel.controlleradvice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Range(min = 10, max = 100_000_000)
    private int population;

    @Min(value = 20)
    @Max(value = 10_000, message = "Are you sure this city is that big?!")
    private int area;

    @NotEmpty
    @Email
    private String email;

    public City(String name, int population, int area, String email) {
        this.name = name;
        this.population = population;
        this.area = area;
        this.email = email;
    }
}
