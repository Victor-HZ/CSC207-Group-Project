package apis;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ticketmaster {

    private static final String API_TOKEN = "xbsv7k979hAXbFcLNdLoUTHBdQwQYPBL";

    public static void main(String[] args) {
        getEvent("Toronto", "2023-10-01T23:59:00Z");
    }
    private static String dayTimeHelper(String date){
        return "2023-10-08T23:59:00Z";
    }

    public static void getEvent(String city, String date) throws JSONException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(String.format("https://app.ticketmaster.com/discovery/v2/events.json?apikey=%s", API_TOKEN))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("startDateTime", date)
                .addHeader("endDateTime", dayTimeHelper(date))
                .addHeader("city", city)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());

            if (response.code()== 200 ) {
                JSONObject result = responseBody.getJSONObject("_embedded");

                JSONArray membersArray = result.getJSONArray("events");
                String[] events = new String[membersArray.length()];
                for (int i = 0; i < membersArray.length(); i++) {
                    events[i] = membersArray.getJSONObject(i).getString("name");
                }
                for (String eventName : events){
                    System.out.println(eventName);
                }
            } else {
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
