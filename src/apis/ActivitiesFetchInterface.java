package apis;

import org.json.JSONException;
import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import user.entity.User;

import java.util.ArrayList;

public interface ActivitiesFetchInterface {
    ArrayList<Activity> getEvents(Address address, DayInfo date, String apiToken) throws JSONException;
    void setApiToken(String apiToken);
    User.API_TOKEN getApi();
}
