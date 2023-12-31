package plan.service.add_activity;
import plan.entity.activity.Activity;
import plan.entity.plan.Plan;

public class AddActivityInputData {
    final Plan plan;
    final Activity activity;

    public AddActivityInputData(Plan plan, Activity activity) {
        this.plan = plan;
        this.activity = activity;
    }

    Plan getPlan() {
        return plan;
    } // get plan from editor view

    Activity getActivity() {
        return activity;
    } // activity is selected
}
