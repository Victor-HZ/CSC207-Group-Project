package plan.service.add_activity.interface_adapter;

import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.add_activity.AddActivityOutputData;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesViewModel;
import view.interface_adapter.ViewManagerModel;

public class AddActivityPresenter implements AddActivityOutputBoundary {
    private final FetchActivitiesViewModel selectionScreen;
    private final LoadPlanViewModel editorScreen;
    private ViewManagerModel viewManagerModel;

    public AddActivityPresenter(ViewManagerModel viewManagerModel,
                                FetchActivitiesViewModel fetchActivitiesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.selectionScreen = fetchActivitiesViewModel;
    }
    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
