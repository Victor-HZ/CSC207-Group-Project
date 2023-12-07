package apis.ticketmaster;

import org.junit.Before;
import org.junit.Test;
import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.address.InvalidProvinceException;
import plan.entity.day_info.Date;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public class TicketmasterAPITest {

    private DayInfo day;
    private Address address;

    @Before
    public void init() throws InvalidProvinceException {
        day = new Date();
        day.setYear(2024);
        day.setMonth(1);
        day.setDay(1);
        day.setHour(15);

        address = new CanadaAddress();
        address.setCity("Vancouver");
        address.setProvince("BC");
    }

    @Test
    public void TestGetEvents(){
        TicketmasterAPI api = new TicketmasterAPI();
        ArrayList<Activity> result = api.getEvents(address, day, System.getenv("TICKETMASTER_API_TOKEN"));
    }
}
