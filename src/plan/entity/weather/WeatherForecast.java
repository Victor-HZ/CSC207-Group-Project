package plan.entity.weather;

import apis.weather.WeatherAPI;
import plan.entity.address.Address;
import plan.entity.day_info.Date;

import java.io.IOException;

public class WeatherForecast extends WeatherAPI implements Weather {
    public String weatherToString() {
        return weather.toString();
    }

    // Use this instead of weatherToString, it was a little buggy for some reason
    @Override
    public String toString() {
        return weatherToString();
    }

    @Override
    public void setWeather(Date day, Address address) throws IOException {
        updateWeather(day, address);
    }
}
