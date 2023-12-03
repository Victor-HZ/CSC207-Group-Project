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
    } // get from editor view!!

    Activity getActivity() {
        return activity;
    } // will be selected
}
