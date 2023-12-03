package plan.service.create_plan;

public interface CreatePlanOutputBoundary {
    void prepareEditorView(CreatePlanOutputData user);
    void prepareFailView(String error);
}
