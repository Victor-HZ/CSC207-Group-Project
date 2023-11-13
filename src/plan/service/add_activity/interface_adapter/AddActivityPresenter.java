package plan.service.add_activity.interface_adapter;

import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.add_activity.AddActivityOutputData;

public class AddActivityPresenter implements AddActivityOutputBoundary {
    @Override
    public void prepareSuccessView(AddActivityOutputData plan) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
