package com.weather.jpa.repository;

import org.springframework.stereotype.Repository;
import com.weather.jpa.domain.WeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("weatherRepository")
public interface WeatherRepository extends JpaRepository<WeatherReport, Long>{

}