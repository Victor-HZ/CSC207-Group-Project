package plan.service.delete_activity.interface_adapter;

import plan.service.delete_activity.DeleteActivityOutputBoundary;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import view.interface_adapter.ViewManagerModel;

public class DeleteActivityPresenter implements DeleteActivityOutputBoundary {
    private final EditorViewModel editorScreen;
    private ViewManagerModel viewManagerModel;

    public DeleteActivityPresenter(ViewManagerModel viewManagerModel,
                                EditorViewModel editorScreen) {
        this.viewManagerModel = viewManagerModel;
        this.editorScreen = editorScreen;
    }
    @Override
    public void prepareSuccessView() {
        // on success, reapply editor view to show updated plan!
        EditorState editorState = editorScreen.getState();
        this.editorScreen.setState(editorState);
        this.editorScreen.firePropertyChanged();

        this.viewManagerModel.setActiveView(editorScreen.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        EditorState editorState = editorScreen.getState();
        editorState.setDeleteActivityError(error);
        editorScreen.firePropertyChanged();
    }
}
