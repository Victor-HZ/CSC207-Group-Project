package plan.service.create_plan;

import plan.entity.day_info.DayInfo;

public interface CreatePlanInputBoundary {
    void execute(DayInfo dayInfo);
}
