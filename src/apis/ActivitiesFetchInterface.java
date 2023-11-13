package apis;

import org.json.JSONException;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public interface ActivitiesFetchInterface {
    ArrayList<Activity> getEvents(String city, DayInfo date) throws JSONException;
}
