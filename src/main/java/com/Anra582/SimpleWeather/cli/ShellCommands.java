package com.Anra582.SimpleWeather.cli;

import com.Anra582.SimpleWeather.weather.RestWeatherRetriever;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Arrays;
import java.util.List;

@ShellComponent
public class ShellCommands {

    private final RestWeatherRetriever restWeatherRetriever;

    public ShellCommands(RestWeatherRetriever restWeatherRetriever) {
        this.restWeatherRetriever = restWeatherRetriever;
    }


    @ShellMethod("Say hi")
    public String testo() {
        return "Oh, hi Mark";
    }

    @ShellMethod("Show all samples")
    public List<String> showall() {
        return Arrays.asList("WOW", "Such", "returning", "list");
    }

    @ShellMethod("Get current weather in city")
    public String get(@ShellOption(defaultValue = "Krasnoyarsk") String city) {
        restWeatherRetriever.getWeather(city);
        return String.format("You're choose a {%s}", city);
    }

}
