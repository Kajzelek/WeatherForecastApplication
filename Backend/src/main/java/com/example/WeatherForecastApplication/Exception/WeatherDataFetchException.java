package com.example.WeatherForecastApplication.Exception;

public class WeatherDataFetchException extends RuntimeException {
    public WeatherDataFetchException(String s) {
        super(s);
    }
    public WeatherDataFetchException(String s, Throwable cause) {
        super(s, cause);
    }
}
