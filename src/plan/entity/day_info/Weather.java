package plan.entity.day_info;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Weather {

    public String rain;
    public String weather;

    // Must be within 14 days
    public void updateWeather(Date dayInfo, Coordinate coordinate) throws IOException {
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
    private static String getString(Date dayInfo, Coordinate coordinate) {
        String coordinates = coordinate.getCoor();
        int divider = coordinates.indexOf(',');
        String longitude = coordinates.substring(0, divider);
        String latitude = coordinates.substring(divider + 1);
        String startDate = dayInfo.getStart();
        String endDate = dayInfo.getEnd();

        return "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,rain&start_date=" + startDate + "&end_date=" + endDate;
    }
}

