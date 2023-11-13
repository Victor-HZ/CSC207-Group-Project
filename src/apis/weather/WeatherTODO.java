package apis.weather;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import plan.entity.day_info.DayInfo;
import plan.entity.day_info.ToStringType;

import java.io.IOException;

public class WeatherTODO {
//TODO note: I not quite sure if this class can be merged to WeatherAPI.java? Both files look like api call
    public String rain;
    public String weather;

    // Must be within 14 days
    public void updateWeather(DayInfo dayInfo, Coordinate coordinate) throws IOException {
        // TODO note: if this is a user-interactive method we could certainly add a new use case which allows user to refresh and update the weather of the plan.
        String apiUrl = getString(dayInfo, coordinate);


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            weather = response.body().string();
            // Try and make weather more readable
            // Add something to change weather
        }

    }

    @NotNull // what is that
    private static String getString(DayInfo day, Coordinate coordinate) { //TODO note: should use interface instead of the actual entity from my pov. Not sure if I understand DIP correctly, we can certainly discuss about it!
        String coordinates = coordinate.getCoor();
        int divider = coordinates.indexOf(',');
        String longitude = coordinates.substring(0, divider);
        String latitude = coordinates.substring(divider + 1);
        String startDate = day.toString(ToStringType.WEATHER);

        //TODO note: The date entity represents a single day. Thus if you want to have a period of time probably should use two separate initializations of date.
        Integer TIME_LENGTH = 14;
        day.addDays(TIME_LENGTH);
        String endDate = day.toString(ToStringType.WEATHER);
        day.addDays(-TIME_LENGTH);


        return "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,rain&start_date=" + startDate + "&end_date=" + endDate;
    }
}

