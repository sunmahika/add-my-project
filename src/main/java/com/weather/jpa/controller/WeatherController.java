package com.weather.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.weather.jpa.domain.WeatherReport;
import com.weather.jpa.repository.WeatherRepository;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherRepository repository;
	
	@GetMapping("/weatherReport")
	public List<WeatherReport> getData() {
		return repository.findAll();
	}
	
	@PostMapping("/weatherReport")
	public WeatherReport addWeatherReport(@RequestBody WeatherReport cases) {
		return repository.save(cases);
	}
	
	@PutMapping("/weatherReport")
	public WeatherReport updateWeatherReport(@RequestBody WeatherReport cases) {
		return repository.save(cases);
		
	}
	
	@GetMapping("/weatherReport/{id}") 
	public WeatherReport view(@PathVariable Long id) {
		Optional<WeatherReport> op= repository.findById(id);
		WeatherReport WeatherReport = null;
		if(op.isPresent()) 
			WeatherReport	= op.get();
		return WeatherReport;
		
	
	}
	
	@DeleteMapping("/weatherReport/{id}")
	public boolean deleteUsers(@PathVariable Long id) {
		repository.deleteById(id);
		return true;
	}
	
}
