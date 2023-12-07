package apis.tripAdvisor;

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
import plan.entity.day_info.ToStringType;
import user.entity.User;


public class TripAdvisorAPI implements ActivitiesFetchInterface {

    private static String API_TOKEN;


    @Override
    public ArrayList<Activity> getEvents(Address address, DayInfo date, String apiToken) throws JSONException {
        setApiToken(apiToken);
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        HttpUrl.Builder httpBuilder = HttpUrl.parse("https://app.ticketmaster.com/discovery/v2/events").newBuilder()
//                .addQueryParameter("apikey", API_TOKEN)
//                .addQueryParameter("startDateTime", date.toString(ToStringType.TICKETMASTER))
//                .addQueryParameter("countryCode", "CA");
//        Request request = new Request.Builder().url(httpBuilder.build()).build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response);
//
//            if (response.code() == 200) {
//                assert response.body() != null;
//                JSONObject responseBody = new JSONObject(response.body().string());
//                JSONObject result = responseBody.getJSONObject("_embedded");
//
//                JSONArray membersArray = result.getJSONArray("events");
//                ArrayList<Activity> activities = new ArrayList<>();
//                for (int i = 0; i < membersArray.length(); i++) {
//                    Activity event = new Event();
//                    Address address = new CanadaAddress();
//                    try {
//                        event.setName(membersArray.getJSONObject(i).getString("name"));
//                        event.setCost(membersArray.getJSONObject(1).getJSONArray("priceRanges").getJSONObject(0).getDouble("min"));
//                        event.setAddress(address);
//                        event.setDescription(membersArray.getJSONObject(i).getString("info"));
//                        activities.add(event);
//                    } catch (Exception ignored) {
//
//                    }
//                }
//                return activities;
//            } else {
//                assert response.body() != null;
//                JSONObject responseBody = new JSONObject(response.body().string());
//                throw new RuntimeException(responseBody.getString("message"));
//            }
//        } catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }
        return new ArrayList<>();
    }

    @Override
    public void setApiToken(String apiToken) {
        API_TOKEN = apiToken;
    }

    @Override
    public User.API_TOKEN getApi() {
        return User.API_TOKEN.TripAdvisor;
    }
}
