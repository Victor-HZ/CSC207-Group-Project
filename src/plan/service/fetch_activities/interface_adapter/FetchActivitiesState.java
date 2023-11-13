package plan.service.fetch_activities.interface_adapter;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

public class FetchActivitiesState {
    private Address address = null;
    private DayInfo date = null;

    public FetchActivitiesState(FetchActivitiesState copy) {
        address = copy.address;
        date = copy.date;
    }

    public FetchActivitiesState() {}

    public Address getAddress(){
        return address;
    }

    public DayInfo getDate(){
        return date;
    }
}
