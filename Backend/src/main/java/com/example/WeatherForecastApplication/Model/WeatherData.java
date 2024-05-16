package com.example.WeatherForecastApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class WeatherData {
    private int weatherCode;
    private double maxTemperature;
    private double minTemperature;
    private List<Double> temperatures;
}