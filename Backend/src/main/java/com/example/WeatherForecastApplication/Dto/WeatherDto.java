package com.example.WeatherForecastApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherDto {
    private LocalDate date;
    private Integer weatherCode;
    private Double maxTemperature;
    private Double minTemperature;
}
