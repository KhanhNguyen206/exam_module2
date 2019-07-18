package com.khanhnn.exam_module2.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_Id")
    private Country country;

    @NotNull
    @Min(10)
    @Max(1000000)
    private Long area;

    @NotNull
    @Min(100)
    private Long population;

    @NotNull
    @Min(0)
    private Long GDP;

    @Column(columnDefinition = "long")
    @NotEmpty
    private String description;

    public City() {
    }

    public City(@NotEmpty @Size(min = 1, max = 30) String name, Country country, @NotNull @Min(10) @Max(1000000) Long area, @NotNull @Min(100) Long population, @NotNull @Min(0) Long GDP, @NotEmpty String description) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
