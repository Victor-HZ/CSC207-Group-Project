package apis.weather;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.entity.day_info.ToStringType;

import java.io.IOException;
import java.util.Objects;

public class WeatherAPI {
    public String rain;
    public String temp;
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
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonData = responses.body().string();
        JSONObject jsonObject = new JSONObject(jsonData);

        weather = jsonObject.getJSONObject("hourly");

        setTemp();
        setRain();

    }

    public void setTemp() {
        JSONArray tempArray = weather.getJSONArray("temperature_2m");
        float hourCounter = 0;
        float tempHolder = 0;
        for (int i = 0; i < tempArray.length(); i++) {
            hourCounter = hourCounter + 1;
            tempHolder = tempHolder + tempArray.getFloat(i);
        }
        temp = String.format("%.1f °C", tempHolder / hourCounter);
    }

    public void setRain() {
        JSONArray rainArray = weather.getJSONArray("rain");
        for (int i = 0; i < rainArray.length(); i++) {
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

    public String getRain() {
        return rain;
    }

    public String getTemp() {return temp;}
}

