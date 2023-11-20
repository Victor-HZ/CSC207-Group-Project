package plan.service.add_activity.interface_adapter;

import plan.entity.activity.Activity;
import plan.entity.plan.Plan;
import plan.service.add_activity.AddActivityInputBoundary;
import plan.service.add_activity.AddActivityInputData;

public class AddActivityController {
    final AddActivityInputBoundary addActivityInteractor;
    public AddActivityController(AddActivityInputBoundary addActivityInteractor) {
        this.addActivityInteractor = addActivityInteractor;
    }

    public void execute(Plan plan, Activity activity) {
        AddActivityInputData addActivityInputData = new AddActivityInputData(plan, activity);

        addActivityInteractor.execute(addActivityInputData);
    }
}