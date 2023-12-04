package plan.entity.weather;

import apis.weather.WeatherAPI;

public class WeatherForcast extends WeatherAPI implements Weather {
    public String weatherToString() {
        return weather.toString();
    }

    @Override
    public String toString() {
        return weatherToString();
    }
}
