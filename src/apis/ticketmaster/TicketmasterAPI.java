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
import user.entity.User;


public class TicketmasterAPI implements ActivitiesFetchInterface {

    private static String API_TOKEN;

    @Override
    public ArrayList<Activity> getEvents(Address address, DayInfo date, String apiToken) throws JSONException {
        setApiToken(apiToken);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl.Builder httpBuilder = HttpUrl.parse("https://app.ticketmaster.com/discovery/v2/events").newBuilder()
                .addQueryParameter("apikey", API_TOKEN)
                .addQueryParameter("startDateTime", date.toString(ToStringType.TICKETMASTER))
                .addQueryParameter("city", address.getCity())
                .addQueryParameter("stateCode", address.getProvince())
                .addQueryParameter("countryCode", address.getCountry());
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
                    Address tempAddress = new CanadaAddress();
                    DayInfo eventDate = new Date();
                    try {
                        event.setName(membersArray.getJSONObject(i).getString("name"));
                        event.setCost(
                                (membersArray.getJSONObject(1).getJSONArray("priceRanges").getJSONObject(0).getDouble("min")
                                        + membersArray.getJSONObject(1).getJSONArray("priceRanges").getJSONObject(0).getDouble("max")
                                ) / 2);
                        event.setAddress(tempAddress);

                        String localDate = membersArray.getJSONObject(i).getJSONObject("dates").getJSONObject("start").getString("localDate");
                        String localTime = membersArray.getJSONObject(i).getJSONObject("dates").getJSONObject("start").getString("localTime");
                        eventDate.setYear(Integer.parseInt(localDate.substring(0, 4)));
                        eventDate.setMonth(Integer.parseInt(localDate.substring(5, 7)));
                        eventDate.setDay(Integer.parseInt(localDate.substring(8)));
                        eventDate.setHour(Integer.parseInt(localTime.substring(0, 2)));

                        try {
                            tempAddress.setCountry(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("country").getString("name"));
                            tempAddress.setProvince(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("state").getString("name"));
                            tempAddress.setCity(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("city").getString("name"));
                            tempAddress.setBusinessName(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getString("name"));
                            tempAddress.setPostalCode(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getString("postalCode"));
                            tempAddress.setStreetNumber(Integer.parseInt(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("address").getString("line1").split(" ", 2)[0]));
                            tempAddress.setStreetName(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("address").getString("line1").split(" ", 2)[1]);
                            tempAddress.setLatitude(Double.parseDouble(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("location").getString("latitude")));
                            tempAddress.setLongitude(Double.parseDouble(membersArray.getJSONObject(i).getJSONObject("_embedded").getJSONArray("venues").getJSONObject(0).getJSONObject("location").getString("longitude")));
                        } catch (JSONException e){
                            System.out.println("The address is captured unsuccessfully, the address fetched is: " + address.toString());
                        } finally {
                            event.setAddress(tempAddress);
                        }
                        event.setDayInfo(eventDate);
                        String description = new String();
                        try {
                            description = membersArray.getJSONObject(i).getString("info");
                        } catch (Exception E){

                            description = description + "Segment: " + membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("segment").getString("name") + "\n";
                            description = description + "Event Genre: " + membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("genre").getString("name") + "\n";
                            description = description + "Sub Genre: " +  membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("subGenre").getString("name") + "\n";
                            description = description + "Type: " + membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("type").getString("name") + "\n";
                            description = description + "Sub Type: " + membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getJSONObject("subType").getString("name") + "\n";
                            description = description + "Family Style: " + membersArray.getJSONObject(i).getJSONArray("classifications").getJSONObject(0).getBoolean("family") + "\n";
                            description = description + "Age Restrictions: " + membersArray.getJSONObject(i).getJSONObject("ageRestrictions").getBoolean("legalAgeEnforced");
                        } finally {
                            event.setDescription(description);
                        }
                        activities.add(event);


                    } catch (Exception ignored) {
                        try {
                            event.getDayInfo();
                            activities.add(event);
                        } catch (Exception e){
                            System.out.println("Event does not has a time associated");
                        }
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
    public void setApiToken(String  apiToken){
        API_TOKEN = apiToken;
    }

    @Override
    public User.API_TOKEN getApi() {
        return User.API_TOKEN.Ticketmaster;
    }
}
