package plan.entity.activity;


import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

public interface Activity {

    String toString();
    String getName();
    Double getCost();
    Address getAddress();
    String getDescription();
    void setName(String name);
    void setCost(Double cost);
    void setAddress(Address address);
    void setDescription(String description);

    void setDayInfo(DayInfo date);
    DayInfo getDayInfo();

    boolean equals(Activity other);
}
