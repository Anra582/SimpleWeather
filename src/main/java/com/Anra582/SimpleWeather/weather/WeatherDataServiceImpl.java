package com.Anra582.SimpleWeather.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WeatherDataServiceImpl implements WeatherDataService {

    private final Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    private JdbcTemplate jdbcTemplate;

    public WeatherDataServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.debug("Updating table Weather.");
        this.jdbcTemplate.update("CREATE TABLE IF NOT EXISTS Weather (sample text);");
        logger.debug("Update successful");
    }


    @Override
    public void save(String weatherSample) {
        logger.debug(String.format("Saving weather sample {%s} into table", weatherSample));
        jdbcTemplate.update("insert into Weather (sample) values (?)", weatherSample);
        logger.debug("Saved");
    }

    @Override
    public List<String> getAll() {
        return jdbcTemplate.query("select sample from Weather",
                (rs, rowNum) -> rs.getString("sample"));
    }
}
