package plan.service.fetch_activities;

import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public interface FetchActivitiesInputBoundary {
    ArrayList<Activity> execute(DayInfo date, Address addresss);
}
