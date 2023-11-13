package plan.service.fetch_activities;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

public interface FetchActivitiesInputBoundary {
    void execute(DayInfo date, Address addresss);
}
