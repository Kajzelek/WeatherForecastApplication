package com.example.WeatherForecastApplication.Service;

import com.example.WeatherForecastApplication.Api.WeatherApiData;
import com.example.WeatherForecastApplication.Dto.WeatherDto;
import com.example.WeatherForecastApplication.Exception.WeatherDataFetchException;
import com.example.WeatherForecastApplication.Mapper.WeatherMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherMapper weatherMapper;

    public List<WeatherDto> getWeeklyWeather(Double latitude, Double longitude){
        try {
            WeatherApiData data = getWeatherDataFromApi(latitude, longitude);
            return weatherMapper.convertToWeatherDtoList(data);
        }
        catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private WeatherApiData getWeatherDataFromApi(Double latitude, Double longitude){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&daily=weather_code,temperature_2m_max,temperature_2m_min,sunshine_duration";
            ResponseEntity<WeatherApiData> response = restTemplate.getForEntity(url, WeatherApiData.class);

            if(response.getStatusCode() == HttpStatus.OK){
                return response.getBody();
            }
            else{
                throw new WeatherDataFetchException("Error while fetching data from API" + response.getStatusCodeValue());
            }

        }catch (RestClientException e){
            throw new WeatherDataFetchException("Error while fetching data from API" + e.getMessage(), e);

        }
    }



}