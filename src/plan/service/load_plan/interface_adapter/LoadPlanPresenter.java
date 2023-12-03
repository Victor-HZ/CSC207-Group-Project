package plan.service.load_plan.interface_adapter;

import plan.service.load_plan.LoadPlanOutputBoundary;
import plan.service.load_plan.LoadPlanOutputData;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import view.interface_adapter.ViewManagerModel;

public class LoadPlanPresenter implements LoadPlanOutputBoundary {

    private final EditorViewModel editorViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedinViewModel;

    public LoadPlanPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggerViewModel, EditorViewModel editViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedinViewModel = loggerViewModel;
        this.editorViewModel = editViewModel;
    }

    @Override
    public void prepareSuccessView(LoadPlanOutputData outputData) {

        EditorState planState = editorViewModel.getState();


//        planState.setActivities(outputData.getActivities());
//        planState.setTotalCost(outputData.getTotalCost());
//        planState.setDayInfo(outputData.getDayInfo());

        // Update the view model state
//        loadPlanViewModel.setState(planState);
//        loadPlanViewModel.firePropertyChanged();

        // Switch to the editor view
        viewManagerModel.setActiveView(editorViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

//        loadPlanViewModel.setErrorMessage(error);
//        loadPlanViewModel.firePropertyChanged();
    }
}
