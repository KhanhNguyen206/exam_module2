package com.khanhnn.exam_module2.repository;

import com.khanhnn.exam_module2.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
