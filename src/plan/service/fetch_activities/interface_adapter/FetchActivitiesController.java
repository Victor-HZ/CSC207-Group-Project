package plan.service.fetch_activities.interface_adapter;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.service.fetch_activities.FetchActivitiesInputBoundary;
import user.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class FetchActivitiesController {
    final FetchActivitiesInputBoundary fetchActivitiesInteractor;

    public FetchActivitiesController(FetchActivitiesInputBoundary fetchActivitiesInteractor){
        this.fetchActivitiesInteractor = fetchActivitiesInteractor;
    }

    public ArrayList<Activity> execute(DayInfo date, Address address, HashMap<User.API_TOKEN, String> apiTokens){
        return fetchActivitiesInteractor.execute(date, address, apiTokens);
    }
}
