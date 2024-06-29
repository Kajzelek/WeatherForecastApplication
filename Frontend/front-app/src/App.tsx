import './App.css';
import React, {useEffect, useState} from 'react';
import { fetchWeatherData, formatDate } from './Functions/weatherApi';

function App() {

  interface WeatherForecast {
    date: Date,
    weatherCode: number,
    minTemperature: number,
    maxTemperature: number,
  }
  

  const [weatherForecasts, setWeatherForecasts] = useState<WeatherForecast[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await fetchWeatherData({latitude: 52.2297, longitude: 21.0122}); // Użyj rzeczywistych wartości dla szerokości i długości geograficznej
        setWeatherForecasts(data);
      } catch (error) {
        console.error('Error fetching weather data:', error);
      }
    };

    fetchData();
    console.log(weatherForecasts)
  }, []);

  return (
    <div className="App">
      {weatherForecasts.length > 0 ? (
          <ul>
            {weatherForecasts.map((forecast, index) => (
              <li key={index}>
                Data: {formatDate(new Date(forecast.date))}, TemperaturaMin: {forecast.minTemperature}°C, TemperaturaMax: {forecast.maxTemperature}°C, KodPogody: {forecast.weatherCode}
              </li>
            ))}
          </ul>
      ) : (
        <p>Ładowanie danych pogodowych...</p>
      )} 
    </div>
  );
}

export default App;
