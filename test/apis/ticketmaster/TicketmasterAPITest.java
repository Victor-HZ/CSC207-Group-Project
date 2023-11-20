package apis.ticketmaster;

import org.junit.Before;
import org.junit.Test;
import plan.entity.activity.Activity;
import plan.entity.day_info.Date;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public class TicketmasterAPITest {

    private DayInfo day;

    @Before
    public void init(){
        day = new Date();
        day.setYear(2023);
        day.setMonth(11);
        day.setDay(10);
        day.setHour(15);
    }

    @Test
    public void TestGetEvents(){
        TicketmasterAPI api = new TicketmasterAPI();
        ArrayList<Activity> result = api.getEvents("Toronto", day);
    }
}
