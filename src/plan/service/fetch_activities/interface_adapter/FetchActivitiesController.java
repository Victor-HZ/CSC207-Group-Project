package plan.service.fetch_activities.interface_adapter;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.service.fetch_activities.FetchActivitiesInputBoundary;

public class FetchActivitiesController {
    final FetchActivitiesInputBoundary fetchActivitiesInteractor;

    public FetchActivitiesController(FetchActivitiesInputBoundary fetchActivitiesInteractor){
        this.fetchActivitiesInteractor = fetchActivitiesInteractor;
    }

    public void execute(DayInfo date, Address address){
        fetchActivitiesInteractor.execute(date, address);
    }
}
