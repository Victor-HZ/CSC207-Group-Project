package entity.dayinfo;
import entity.address.Address;
import okhttp3.*;

import java.io.IOException;

public class Coordinate {

    private static final String key = "MOQVblMcc434KJ1J8FdvXQ==Ayp3zVUoy5vC64XQ";
    public String coordinate;

    public void updateCoor(Address address) throws IOException {
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
            String temp = response.body().string();
            int latStart = temp.indexOf("latitude") + 11;
            int latEnd = latStart + 7;
            int longStart = temp.indexOf("longitude") + 12;
            int longEnd = longStart + 7;
            coordinate = temp.substring(latStart, latEnd) + "," + temp.substring(longStart, longEnd);
        }
    }

    public String getCoor() {
        return coordinate;
    }
}
