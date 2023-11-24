package plan.service.add_activity.interface_adapter;

import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.main_view_models.EditorViewModel;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesViewModel;
import view.interface_adapter.ViewManagerModel;

public class AddActivityPresenter implements AddActivityOutputBoundary {
    private final FetchActivitiesViewModel selectionScreen;
    private final EditorViewModel editorScreen;
    private ViewManagerModel viewManagerModel;

    public AddActivityPresenter(ViewManagerModel viewManagerModel,
                                FetchActivitiesViewModel fetchActivitiesViewModel,
                                EditorViewModel editorScreen) {
        this.viewManagerModel = viewManagerModel;
        this.selectionScreen = fetchActivitiesViewModel;
        this.editorScreen = editorScreen;
    }
    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
