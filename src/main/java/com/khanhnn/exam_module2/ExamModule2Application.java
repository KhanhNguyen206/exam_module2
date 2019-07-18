package com.khanhnn.exam_module2;

import com.khanhnn.exam_module2.model.City;
import com.khanhnn.exam_module2.service.CityService;
import com.khanhnn.exam_module2.service.CountryService;
import com.khanhnn.exam_module2.service.impl.CityServiceImpl;
import com.khanhnn.exam_module2.service.impl.CountryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamModule2Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamModule2Application.class, args);
    }

    @Bean
    public CountryService countryService(){
        return new CountryServiceImpl();
    }

    @Bean
    public CityService cityService(){
        return new CityServiceImpl();
    }
}
