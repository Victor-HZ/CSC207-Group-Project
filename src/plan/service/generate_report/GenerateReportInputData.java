package plan.service.generate_report;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;

import java.util.List;

public class GenerateReportInputData {
    private DatePlan datePlan;

    public GenerateReportInputData(DatePlan datePlan) {
        this.datePlan = datePlan;
    }

    public DatePlan getDatePlan() {
        return datePlan;
    }

    public List<Activity> getActivities() {
        return datePlan.getActivities();
    }

    public double getTotalCost() {
        return datePlan.getCost();
    }

    public DayInfo getDayInfo() {
        return datePlan.getDayInfo();
    }
}
