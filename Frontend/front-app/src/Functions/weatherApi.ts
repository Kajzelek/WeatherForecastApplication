import axios, { AxiosResponse } from "axios"

export interface WeatherForecast{
    date: Date,
    weatherCode: number,
    minTemperature: number,
    maxTemperature: number,
}

export const fetchWeatherData = async (params: {latitude: number, longitude: number}): Promise<WeatherForecast[]> => {
    try{
        const response: AxiosResponse<WeatherForecast[]> = await axios.get(`http://localhost:8080/api/v1/forecast?latitude=${params.latitude}&longitude=${params.longitude}`);            
        return response.data
    }catch(error){
        console.error(error)
        throw new Error("Failed to fetch weather data")
        return []
    }
}

export const formatDate = (dateString: Date) => {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    return `${day}-${month}-${year}`;
};