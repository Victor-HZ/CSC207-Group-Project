package apis.weather;
import apis.weather.Coordinate;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.html.HTMLImageElement;
import plan.entity.day_info.Date;
import plan.entity.day_info.DayInfo;
import plan.entity.day_info.ToStringType;

import java.io.IOException;
import java.time.LocalDateTime;

public class WeatherTODO {

    public String rain;
    public String weather;

    // Must be within 14 days
    public void updateWeather(DayInfo dayInfo, Coordinate coordinate) throws IOException {
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

    @NotNull
    private static String getString(DayInfo day, Coordinate coordinate) {
        String coordinates = coordinate.getCoor();
        int divider = coordinates.indexOf(',');
        String longitude = coordinates.substring(0, divider);
        String latitude = coordinates.substring(divider + 1);
        String startDate = day.toString(ToStringType.WEATHER);

        Integer TIME_LENGTH = 14;
        day.addDays(TIME_LENGTH);
        String endDate = day.toString(ToStringType.WEATHER);
        day.addDays(-TIME_LENGTH);


        return "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,rain&start_date=" + startDate + "&end_date=" + endDate;
    }
}
