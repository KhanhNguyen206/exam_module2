package com.khanhnn.exam_module2.service;

import com.khanhnn.exam_module2.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

    Page<City> findAllByNameContaining(String name, Pageable pageable);

    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
