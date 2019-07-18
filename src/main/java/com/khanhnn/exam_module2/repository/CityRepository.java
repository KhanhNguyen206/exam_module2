package com.khanhnn.exam_module2.repository;

import com.khanhnn.exam_module2.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
