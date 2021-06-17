package com.codecool.weatherservice.controller;

import com.codecool.weatherservice.WeatherCache;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WeatherController {

    WeatherCache weatherCache;

    @GetMapping("/")
    public ResponseEntity getWeather() {
        return ResponseEntity.ok(weatherCache.getQuote());
    }
}
