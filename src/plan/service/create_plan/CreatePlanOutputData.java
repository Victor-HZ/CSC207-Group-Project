package plan.service.create_plan;

import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;
import user.entity.User;

public class CreatePlanOutputData {
    private String creationTime;
    private boolean useCaseFailed;
    public Plan plan;
    public User user;

    public CreatePlanOutputData(String creationTime, boolean useCaseFailed, DayInfo dayInfo, User user){
        this.user = user;
        this.plan = new DatePlan(dayInfo);
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public User getUser() {return user;}
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
