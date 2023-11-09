package apis;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weather {
    public static void main(String[] args) {
        try {
            String apiKey = "9fdb34ff07b541a686873a61eb61c9b1";

            // This sample API call returns the 48-hour forecast of the city Raleigh in North Carolina.
            String apiUrl = "https://api.weatherbit.io/v2.0/forecast/hourly?city=Raleigh,NC&key=" + apiKey + "&hours=48";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println(response.toString());
            }

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

