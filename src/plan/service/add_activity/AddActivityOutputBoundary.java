package plan.service.add_activity;

public interface AddActivityOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error); // for when activity is already in plan
}
