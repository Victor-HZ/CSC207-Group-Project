package apis.weather;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import plan.entity.address.Address;
import plan.entity.day_info.Date;
import plan.entity.day_info.DayInfo;
import plan.entity.day_info.ToStringType;

import java.io.IOException;
import java.util.Objects;

public class WeatherAPI {
    public String rain;
    public JSONObject weather;

    // Must be within 14 days
    public void updateWeather(DayInfo day, Address address) throws IOException {
        //initialize the url
        String coordinates = address.getCoordinates();
        Integer divider = coordinates.indexOf(',');
        String longitude = coordinates.substring(0, divider);
        String latitude = coordinates.substring(divider + 1);
        String date = day.toString(ToStringType.WEATHER);
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,rain&start_date=" + date + "&end_date=" + date;
        //url call
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;

            JSONObject responseObject = new JSONObject(response);
            JSONArray jsonArray = responseObject.getJSONArray("hourly");
            JSONObject timeTempRain = null;
            for (int i = 0; i < jsonArray.length(); i++) {
                timeTempRain = jsonArray.getJSONObject(i);
            }
            weather = timeTempRain;
        }

        setRain();

    }

    public void setRain() {
        JSONArray rainArray = weather.getJSONArray("rain");
        for (int i = 0; i < rainArray.length(); i++ ) {
            float rainMeter = rainArray.getFloat(i);
            if (2.5 >= rainMeter && rainMeter > 0) {
                if (!Objects.equals(rain, "Moderate Rain") | !Objects.equals(rain, "Heavy Rain")) {
                    rain = "Light Rain";
                }
            } else if (7.6 >= rainMeter && 2.5 > rainMeter) {
                if (!Objects.equals(rain, "Heavy Rain")) {
                    rain = "Moderate Rain";
                }
            } else if (rainMeter > 7.6) {
                rain = "Heavy Rain";
            }
        }
    }
}

