package plan.service.fetch_activities;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

public class FetchActivitiesInputData {
    private final Address address;
    private final DayInfo date;

    public FetchActivitiesInputData(Address address, DayInfo date){
        this.address = address;
        this.date = date;
    }

    Address getAddress(){
        return address;
    }

    DayInfo getDate(){
        return date;
    }
}
