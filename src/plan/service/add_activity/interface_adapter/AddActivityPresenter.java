package plan.service.add_activity.interface_adapter;

import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import view.interface_adapter.ViewManagerModel;

public class AddActivityPresenter implements AddActivityOutputBoundary {
    private final EditorViewModel editorScreen;
    private ViewManagerModel viewManagerModel;

    public AddActivityPresenter(ViewManagerModel viewManagerModel,
                                EditorViewModel editorScreen) {
        this.viewManagerModel = viewManagerModel;
        this.editorScreen = editorScreen;
    }
    @Override
    public void prepareSuccessView() {
        // on success, switch back to plan editor view!
        EditorState editorState = editorScreen.getState();
        this.editorScreen.setState(editorState);
        this.editorScreen.firePropertyChanged();

        this.viewManagerModel.setActiveView(editorScreen.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        EditorState editorState = editorScreen.getState();
        editorState.setAddActivityError(error);
        editorScreen.firePropertyChanged();
    }
}
