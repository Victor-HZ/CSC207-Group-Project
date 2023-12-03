package plan.service.load_plan;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;

import java.util.ArrayList;

public class LoadPlanOutputData {
    private final ArrayList<Activity> activities;
    private final double totalCost;
    private final DayInfo dayInfo;

    public LoadPlanOutputData(ArrayList<Activity> activities, double totalCost, DayInfo dayInfo) {
        this.activities = activities;
        this.totalCost = totalCost;
        this.dayInfo = dayInfo;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public DayInfo getDayInfo() {
        return dayInfo;
    }
}
