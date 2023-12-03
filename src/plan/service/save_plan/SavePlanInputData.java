package plan.service.save_plan;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;

import java.io.File;
import java.util.List;

public class SavePlanInputData {
    private final Plan plan;
    private final File csvFile;

    public SavePlanInputData(Plan plan, File csvFile) {
        this.plan = plan;
        this.csvFile = csvFile;
    }

    public Plan getPlan() {
        return plan;
    }

    public List<Activity> getActivities() {
        return plan.getActivities();
    }

    public double getTotalCost() {
        return plan.getCost();
    }

    public DayInfo getDayInfo() {
        return plan.getDayInfo();
    }
}
