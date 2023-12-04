package plan.service.generate_report;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;
import java.util.List;

public class GenerateReportOutputData {
    private List<Activity> activities;
    private double totalCost;
    private DayInfo dayInfo;

    public GenerateReportOutputData(List<Activity> activities, double totalCost, DayInfo dayInfo) {
        this.activities = activities;
        this.totalCost = totalCost;
        this.dayInfo = dayInfo;
    }

    public ArrayList<Activity> getActivities() {
        return (ArrayList<Activity>) activities;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getDayInfo() {
        return String.valueOf(dayInfo);
    }
}

