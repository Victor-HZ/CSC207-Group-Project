package plan.entity.plan;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public class DatePlan implements Plan{
    DayInfo dayInfo;
    ArrayList<Activity> Events;
    Double totalCost;

    DatePlan(DayInfo dayInfo){
        this.dayInfo = dayInfo;
        this.Events = new ArrayList<>();
        this.totalCost = 0.0;
    }

    void addEvent(Activity event){
        this.Events.add(event);
        this.totalCost += event.getCost();
    }
}
