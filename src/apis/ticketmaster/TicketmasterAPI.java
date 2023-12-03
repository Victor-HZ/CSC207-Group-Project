package apis.ticketmaster;

import java.io.IOException;
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
import plan.entity.day_info.ToStringType;


public class TicketmasterAPI implements ActivitiesFetchInterface {

    private static final String API_TOKEN = System.getenv("TICKETMASTER_API_TOKEN"); // "xbsv7k979hAXbFcLNdLoUTHBdQwQYPBL"

    @Override
    public ArrayList<Activity> getEvents(String city, DayInfo date) throws JSONException {
        final String API_TOKEN = System.getenv("TICKETMASTER_API_TOKEN");
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl.Builder httpBuilder = HttpUrl.parse("https://app.ticketmaster.com/discovery/v2/events").newBuilder()
                .addQueryParameter("apikey", API_TOKEN)
                .addQueryParameter("startDateTime", date.toString(ToStringType.TICKETMASTER))
                .addQueryParameter("countryCode", "CA");
        Request request = new Request.Builder().url(httpBuilder.build()).build();
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
                    DayInfo eventDate = new Date();
                    try {
                        event.setName(membersArray.getJSONObject(i).getString("name"));
                        event.setCost(membersArray.getJSONObject(1).getJSONArray("priceRanges").getJSONObject(0).getDouble("min"));
                        event.setAddress(address);
                        event.setDescription(membersArray.getJSONObject(i).getString("info"));

                        String localDate = membersArray.getJSONObject(i).getJSONObject("dates").getJSONObject("start").getString("localDate"); // 2023-12-01
                        String localTime = membersArray.getJSONObject(i).getJSONObject("dates").getJSONObject("start").getString("localTime"); // 19:30:00
                        eventDate.setYear(Integer.parseInt(localDate.substring(0, 4)));
                        eventDate.setMonth(Integer.parseInt(localDate.substring(5, 7)));
                        eventDate.setDay(Integer.parseInt(localDate.substring(8)));
                        eventDate.setHour(Integer.parseInt(localTime.substring(0, 2)));

                        address.setCountry(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("country").getString("name"));
                        address.setProvince(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("state").getString("name"));
                        address.setCity(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("city").getString("name"));
                        address.setBusinessName(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getString("name"));
                        address.setPostCode(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getString("postalCode"));
                        address.setStreetNumber(Integer.parseInt(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("address").getString("line1").split(" ", 2)[0]));
                        address.setStreetName(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("address").getString("line1").split(" ", 2)[1]);
                        address.setLatitude(Double.parseDouble(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("location").getString("latitude")));
                        address.setLongitude(Double.parseDouble(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONObject("venues").getJSONObject("location").getString("longitude")));

                        event.setAddress(address);
                        event.setDayInfo(eventDate);
                        activities.add(event);
                    } catch (Exception ignored) {

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
