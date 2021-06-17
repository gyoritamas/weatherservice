package com.codecool.weatherservice;

import com.codecool.weatherservice.modell.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class WeatherserviceApplication {

	@Value("${apikey}")
	String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(WeatherserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			System.out.println(apiKey);
			Quote quote = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/weather?units=metric&q=Budapest&appid="+apiKey, Quote.class);

			WeatherCache weatherCache = new WeatherCache(quote);

			System.out.println(weatherCache.getQuote().toString());
		};
	}
}