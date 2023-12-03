package plan.service.generate_report;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public DayInfo getDayInfo() {
        return dayInfo;
    }
}

