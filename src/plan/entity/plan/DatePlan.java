package plan.entity.plan;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public class DatePlan implements Plan{
    DayInfo dayInfo;
    ArrayList<Activity> activites;
    Double totalCost;

    DatePlan(DayInfo dayInfo){
        this.dayInfo = dayInfo;
        this.activites = new ArrayList<>();
        this.totalCost = 0.0;
    }


    @Override
    public void addActivity(Activity activity) {
        this.activites.add(activity);
        this.totalCost += activity.getCost();
    }

    @Override
    public void deleteActivity(Activity activity) {
        activites.remove(activity);
    }

    @Override
    public double getCost() {
        return this.totalCost;
    }

    @Override
    public ArrayList<Activity> getActivities() {
        return activites;
    }

    @Override
    public DayInfo getDayInfo() {
        return dayInfo;
    }
}
