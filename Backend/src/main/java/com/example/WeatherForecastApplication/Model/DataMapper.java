package com.example.WeatherForecastApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataMapper {
    private double latitude;
    private double longitude;
    private Map<String, String> hourly_units;
    private Map<String, List<String>> hourly;
    private Map<String, String> daily_units;
    private Map<String, List<String>> daily;
}
