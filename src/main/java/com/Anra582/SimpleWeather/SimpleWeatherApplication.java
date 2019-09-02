package com.Anra582.SimpleWeather;

import com.Anra582.SimpleWeather.weather.WeatherDataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class SimpleWeatherApplication {

	private final Logger logger = LoggerFactory.getLogger(SimpleWeatherApplication.class);

	private final WeatherDataServiceImpl weatherDataService;

    public SimpleWeatherApplication(WeatherDataServiceImpl weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    public static void main(String[] args) {
		SpringApplication.run(SimpleWeatherApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
