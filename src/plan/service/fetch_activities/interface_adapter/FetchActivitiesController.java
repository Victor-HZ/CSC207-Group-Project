package plan.service.fetch_activities.interface_adapter;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.service.fetch_activities.FetchActivitiesInputBoundary;

import java.util.ArrayList;

public class FetchActivitiesController {
    final FetchActivitiesInputBoundary fetchActivitiesInteractor;

    public FetchActivitiesController(FetchActivitiesInputBoundary fetchActivitiesInteractor){
        this.fetchActivitiesInteractor = fetchActivitiesInteractor;
    }

    public ArrayList<Activity> execute(DayInfo date, Address address){
        return fetchActivitiesInteractor.execute(date, address);
    }
}
