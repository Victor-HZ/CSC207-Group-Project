package plan.service.delete_activity;

import plan.entity.activity.Activity;
import plan.entity.plan.Plan;

public class DeleteActivityInputData {
    final Plan plan;
    final Activity activity;

    public DeleteActivityInputData(Plan plan, Activity activity) {
        this.plan = plan;
        this.activity = activity;
    }

    Plan getPlan() {
        return plan;
    }

    Activity getActivity() {
        return activity;
    }
}
