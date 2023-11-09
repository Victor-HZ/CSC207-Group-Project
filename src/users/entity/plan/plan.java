package users.entity.plan;

import entity.activity.Event;
import entity.dayinfo.DayInfo;

import java.util.ArrayList;

public class plan {
    DayInfo dayInfo;
    ArrayList<Event> Events;
    Double totalCost;

    plan(DayInfo dayInfo){
        this.dayInfo = dayInfo;
        this.Events = new ArrayList<>();
        this.totalCost = 0.0;
    }

    void addEvent(Event event){
        this.Events.add(event);
        this.totalCost += event.getCost();
    }
}
