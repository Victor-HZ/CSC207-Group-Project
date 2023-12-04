package apis.weather;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import plan.entity.address.Address;

import java.io.IOException;
import java.util.HashMap;

public class Coordinate {
    static Dotenv dotenv = Dotenv.load();
    private static final String key = dotenv.get("COORDINATE_API_TOKEN");

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
            HashMap<String,Double> result = new HashMap();
            int latStart = temp.indexOf("latitude") + 11;
            int latEnd = latStart + 7;
            int longStart = temp.indexOf("longitude") + 12;
            int longEnd = longStart + 7;
            result.put("Latitude", Double.parseDouble(temp.substring(latStart, latEnd)));
            result.put("Longtitude", Double.parseDouble(temp.substring(longStart, longEnd)));
            return result;
        }
    }
}
