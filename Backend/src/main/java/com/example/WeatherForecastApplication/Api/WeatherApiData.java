package com.example.WeatherForecastApplication.Api;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class WeatherApiData {
    DailyWeather daily;
}
