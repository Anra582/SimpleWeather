package com.Anra582.SimpleWeather.weather;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherImportDTO {
    private String name;
    private WeatherMainPart main;

    public WeatherImportDTO() {
    }

    public String getName() {
        return name;
    }

    public WeatherMainPart getMain() {
        return main;
    }

    public String toString()
    {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("%s %s %sc", date, this.name, this.main.getTemp());
    }
}
