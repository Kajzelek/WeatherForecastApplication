package com.example.WeatherForecastApplication.Api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
public class DailyWeather{
    List<LocalDate> time;
    List<Integer> weather_code;
    List<Double> temperature_2m_max;
    List<Double> temperature_2m_min;
}
