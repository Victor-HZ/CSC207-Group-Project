package plan.service.create_plan;

public interface CreatePlanOutputBoundary {
    void prepareEditorView(CreatePlanOutputData createPlanOutputData);
    void prepareFailView(String error);
}
