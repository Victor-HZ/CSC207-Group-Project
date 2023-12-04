package plan.service.create_plan;

import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;

public class CreatePlanOutputData {
    private String creationTime;
    private boolean useCaseFailed;
    public Plan plan;

    public CreatePlanOutputData(String creationTime, boolean useCaseFailed, DayInfo dayInfo){
        this.plan = new DatePlan(dayInfo);
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
