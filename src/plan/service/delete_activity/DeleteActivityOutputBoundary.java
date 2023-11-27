package plan.service.delete_activity;

public interface DeleteActivityOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
