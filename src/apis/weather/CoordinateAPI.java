package apis.weather;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import plan.entity.address.Address;

import java.io.IOException;
import java.util.HashMap;

public class CoordinateAPI {
    static Dotenv dotenv = Dotenv.load();
    private static final String key = dotenv.get("COORDINATE_API_TOKEN");
    private Double longitude;
    private Double latitude;

    public HashMap<String, Double> updateCoordinates(Address address) throws IOException{
        String city = address.getCity();
        String country = address.getCountry();

        String request1 = "https://api.api-ninjas.com/v1/geocoding?city=";
        String apiUrl = request1 + city + "&country=" + country;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("X-Api-Key", key)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String temp = response.body().string();
            HashMap<String,Double> result = new HashMap<>();
            int latStart = temp.indexOf("latitude") + 11;
            int latEnd = latStart + 7;
            int longStart = temp.indexOf("longitude") + 12;
            int longEnd = longStart + 7;
            Double newLat = Double.parseDouble(temp.substring(latStart, latEnd));
            Double newLong = Double.parseDouble(temp.substring(longStart, longEnd));
            result.put("Latitude", newLat);
            result.put("Longitude", newLong);
            setLatitude(newLat);
            setLongitude(newLong);
            return result;
        }
    }

    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLatitude(Double newLatitude) {
        latitude = newLatitude;
    }
    public void setLongitude(Double newLongitude) {
        longitude = newLongitude;
    }
}
