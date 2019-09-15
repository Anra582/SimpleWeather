package com.Anra582.SimpleWeather.weather;

import java.util.List;

public interface WeatherDataService {

    void save(String weatherText);

    List<String> getAll();
}
