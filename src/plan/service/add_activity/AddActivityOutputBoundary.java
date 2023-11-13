package plan.service.add_activity;

public interface AddActivityOutputBoundary {
    void prepareSuccessView(AddActivityOutputData plan);

    void prepareFailView(String error);
}
