package com.example.WeatherForecastApplication.Controller;
import com.example.WeatherForecastApplication.Dto.WeatherDto;
import org.springframework.http.ResponseEntity;
import com.example.WeatherForecastApplication.Service.WeatherService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated
public class WeatherController {

    private final WeatherService weatherService;
    @GetMapping("/forecast")
    public ResponseEntity<List<WeatherDto>> getWeeklyWeather(@RequestParam Double latitude, @RequestParam Double longitude){
        return ResponseEntity.ok(weatherService.getWeeklyWeather(latitude, longitude));
    }
}