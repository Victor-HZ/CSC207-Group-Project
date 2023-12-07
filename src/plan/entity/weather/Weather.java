package plan.entity.weather;

import plan.entity.address.Address;
import plan.entity.day_info.Date;

import java.io.IOException;

public interface Weather {
    // When calling weather using an activity, input the DateInfo
    // of the activity and address of the activity into setWeather.

    // Similarly for the overall plan, do likewise but DateInfo of the plan
    // and address of the first or last activity (it shouldn't matter as it is city based)

    String toString();
    void setWeather(Date day, Address address) throws IOException;
    String getRain();
    String getTemp();
}
