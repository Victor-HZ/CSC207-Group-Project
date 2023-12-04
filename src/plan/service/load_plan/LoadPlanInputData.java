package plan.service.load_plan;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;

import java.util.List;

public class LoadPlanInputData {
    private DatePlan datePlan;

    public LoadPlanInputData(DatePlan datePlan) {
        this.datePlan = datePlan;
    }

    public DatePlan getPlan() {
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