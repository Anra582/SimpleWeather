package com.Anra582.SimpleWeather.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RestWeatherRetriever implements WeatherRetriever {

    private final String URL_COMMUNITY_OPEN_WEATHER = "https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q=";
    private final String X_RAPIDAPI_HOST = "community-open-weather-map.p.rapidapi.com";
    private final String X_RAPIDAPI_KEY = "b76c131aa4msh861b05768650d7ap163401jsn9ce105d42c36";


    private final Logger logger = LoggerFactory.getLogger(RestWeatherRetriever.class);

    private final RestTemplate restTemplate;

    public RestWeatherRetriever(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherImportDTO getWeather(String city) {

        System.out.println("Hi, you're in getWeather()");
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("x-rapidapi-host" , X_RAPIDAPI_HOST);
        headers.add("x-rapidapi-key", X_RAPIDAPI_KEY);

        WeatherImportDTO weatherImportDTO;

        try {
            System.out.println(URI.create(URL_COMMUNITY_OPEN_WEATHER + city).toString());


            HttpEntity<String> response = restTemplate.exchange(URI.create(URL_COMMUNITY_OPEN_WEATHER + city),
                    HttpMethod.GET, new HttpEntity<>(headers), String.class);

            System.out.println(response.getBody());

        } catch (RestClientException e) {
            e.printStackTrace();
        }




        return null;
    }
}
