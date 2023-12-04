package plan.service.fetch_activities;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public interface FetchActivitiesInputBoundary {
    ArrayList<Activity> execute(DayInfo date, Address addresss, HashMap<User.API_TOKEN, String> apiTokens);
}
