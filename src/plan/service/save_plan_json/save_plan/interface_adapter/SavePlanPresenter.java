package plan.service.save_plan_json.save_plan.interface_adapter;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import plan.service.save_plan_json.save_plan.SavePlanOutputBoundary;
import plan.service.save_plan_json.save_plan.SavePlanOutputData;

public class SavePlanPresenter implements SavePlanOutputBoundary {
    private final EditorViewModel editorViewModel;

    public SavePlanPresenter(EditorViewModel editorViewModel) {
        this.editorViewModel = editorViewModel;
    }

    @Override
    public void prepareSuccessView(SavePlanOutputData savePlanOutputData) {
        // This doesn't really do anything as far as I know, but feel free to correct me
    }

    @Override
    public void prepareFailView(String error) {
        EditorState editorState = editorViewModel.getState();
        editorState.savePlanError(error);
        editorViewModel.firePropertyChanged();
    }

}
