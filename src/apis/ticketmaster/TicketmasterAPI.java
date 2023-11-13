package apis.ticketmaster;

import java.io.IOException;
import java.time.DateTimeException;
import java.util.ArrayList;

import apis.ActivitiesFetchInterface;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import plan.entity.activity.Activity;
import plan.entity.activity.Event;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.day_info.Date;
import plan.entity.day_info.DayInfo;


public class TicketmasterAPI implements ActivitiesFetchInterface {

    private static final String API_TOKEN = "xbsv7k979hAXbFcLNdLoUTHBdQwQYPBL";

    public static void main(String[] args) throws DateTimeException {
        DayInfo day = new Date();
        day.setYear(2023);
        day.setMonth(11);
        day.setDay(10);
        day.setHour(15);
//        getEvents("Toronto", new Date());
    }

    private static String dayTimeHelper(DayInfo date) {
        return "2023-11-08T23:59:00Z";
    }

    public ArrayList<Activity> getEvents(String city, DayInfo date) throws JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://app.ticketmaster.com/discovery/v2/events")
                .addHeader("apikey", API_TOKEN)
                .addHeader("startDateTime", date.toString())
                .addHeader("countryCode", "CA")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);

            if (response.code() == 200) {
                assert response.body() != null;
                JSONObject responseBody = new JSONObject(response.body().string());
                JSONObject result = responseBody.getJSONObject("_embedded");

                JSONArray membersArray = result.getJSONArray("events");
                ArrayList<Activity> activities = new ArrayList<>();
                for (int i = 0; i < membersArray.length(); i++) {
                    Activity event = new Event();
                    Address address = new CanadaAddress();
                    try {
                        event.setName(membersArray.getJSONObject(i).getString("name"));
                        event.setCost(membersArray.getJSONObject(1).getJSONArray("priceRanges").getJSONObject(0).getDouble("min"));
                        event.setAddress(address);
                        event.setDescription(membersArray.getJSONObject(i).getString("info"));
                        activities.add(event);
                    } catch (Exception ignored){

                    }
                }
                return activities;
            } else {
                assert response.body() != null;
                JSONObject responseBody = new JSONObject(response.body().string());
                throw new RuntimeException(responseBody.getString("message"));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
