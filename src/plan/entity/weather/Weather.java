package plan.entity.weather;

import plan.entity.address.Address;
import plan.entity.day_info.Date;

import java.io.IOException;

public interface Weather {
    String toString();
    void setWeather(Date day, Address address) throws IOException;
    String getRain();
}
