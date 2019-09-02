package com.Anra582.SimpleWeather.cli;

import com.Anra582.SimpleWeather.weather.RestWeatherRetriever;
import com.Anra582.SimpleWeather.weather.WeatherDataServiceImpl;
import com.Anra582.SimpleWeather.weather.WeatherImportDTO;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class ShellCommands {

    private final RestWeatherRetriever restWeatherRetriever;
    private final WeatherDataServiceImpl weatherDataService;

    public ShellCommands(RestWeatherRetriever restWeatherRetriever, WeatherDataServiceImpl weatherDataService) {
        this.restWeatherRetriever = restWeatherRetriever;
        this.weatherDataService = weatherDataService;
    }

    @ShellMethod("Show all samples")
    public List<String> showall() {
        return weatherDataService.getAll();
    }

    @ShellMethod("Get current weather in city")
    public String get(@ShellOption(defaultValue = "Krasnoyarsk") String city) {
        WeatherImportDTO weatherImportDTO = restWeatherRetriever.getWeather(city);

        weatherDataService.save(weatherImportDTO.toString());
        return String.format("Current temperature in %s is %s ", weatherImportDTO.getName(), weatherImportDTO.getMain().getTemp());
    }

}
