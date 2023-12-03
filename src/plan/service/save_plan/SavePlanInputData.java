package plan.service.save_plan;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;
import user.entity.User;

import java.io.File;
import java.util.List;

public class SavePlanInputData {
    private final Plan plan;
    private final User commonUser;
    private final File csvFile;

    public SavePlanInputData(Plan plan, File csvFile, User commonUser) {
        this.plan = plan;
        this.csvFile = csvFile;
        this.commonUser = commonUser;
    }
    public User getCommonUser() {return commonUser;}
    public Plan getPlan() {
        return plan;
    }

    public File getCsvFile() {return csvFile;}

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
