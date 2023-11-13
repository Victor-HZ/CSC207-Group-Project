package plan.service.add_activity;
import plan.entity.activity.Activity;
import plan.entity.plan.Plan;

public class AddActivityInteractor implements AddActivityInputBoundary {

    private final AddActivityOutputBoundary addActivityOutputBoundary;

    public AddActivityInteractor (AddActivityOutputBoundary addActivityOutputBoundary) {
        this.addActivityOutputBoundary = addActivityOutputBoundary;
    }
    @Override
    public void execute(AddActivityInputData addActivityInputData) {
        Plan plan = addActivityInputData.getPlan();
        Activity activity = addActivityInputData.getActivity();
    }
}
