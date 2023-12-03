package plan.entity.plan;

import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public interface Plan {
    void addActivity(Activity activity);
    void deleteActivity(Activity activity);
    double getCost();
    ArrayList<Activity> getActivities();
    DayInfo getDayInfo();
}
