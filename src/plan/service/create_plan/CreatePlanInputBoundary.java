package plan.service.create_plan;

import plan.entity.day_info.DayInfo;
import user.entity.User;

public interface CreatePlanInputBoundary {
    void execute(DayInfo dayInfo, User user);
}
