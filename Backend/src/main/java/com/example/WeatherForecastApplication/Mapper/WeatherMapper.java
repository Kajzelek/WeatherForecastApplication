package com.example.WeatherForecastApplication.Mapper;


import com.example.WeatherForecastApplication.Api.WeatherApiData;
import com.example.WeatherForecastApplication.Dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WeatherMapper {
    private final ModelMapper modelMapper;

    public List<WeatherDto> convertToWeatherDtoList(WeatherApiData weatherApiData){
        return weatherApiData.getDaily().getTime().stream()
                .map(date -> {
                    int index = weatherApiData.getDaily().getTime().indexOf(date);
                    return mapToWeatherDto(weatherApiData, index);
                })
                .collect(Collectors.toList());
    }

    private WeatherDto mapToWeatherDto(WeatherApiData weatherApiData, int index){

        WeatherDto weatherDto = modelMapper.map(weatherApiData, WeatherDto.class);

        weatherDto.setDate(weatherApiData.getDaily().getTime().get(index));
        weatherDto.setWeatherCode(weatherApiData.getDaily().getWeather_code().get(index));
        weatherDto.setMaxTemperature(weatherApiData.getDaily().getTemperature_2m_max().get(index));
        weatherDto.setMinTemperature(weatherApiData.getDaily().getTemperature_2m_min().get(index));

        return weatherDto;
    }

}
