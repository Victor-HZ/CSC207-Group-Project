package plan.service.load_plan.interface_adapter;

import plan.service.load_plan.LoadPlanOutputBoundary;
import plan.service.load_plan.LoadPlanOutputData;
import plan.service.load_plan.LoadPlanLoadPlanState;
import plan.service.load_plan.LoadPlanViewModel;
import view.interface_adapter.ViewManagerModel;

public class LoadPlanPresenter implements LoadPlanOutputBoundary {

    private final LoadPlanViewModel loadPlanViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoadPlanPresenter(ViewManagerModel viewManagerModel, LoadPlanViewModel loadPlanViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loadPlanViewModel = loadPlanViewModel;
    }

    @Override
    public void prepareSuccessView(LoadPlanOutputData outputData) {

        LoadPlanState planState = loadPlanViewModel.getState();


        planState.setActivities(outputData.getActivities());
        planState.setTotalCost(outputData.getTotalCost());
        planState.setDayInfo(outputData.getDayInfo());

        // Update the view model state
        loadPlanViewModel.setState(planState);
        loadPlanViewModel.firePropertyChanged();

        // Switch to the load plan view
        viewManagerModel.setActiveView(loadPlanViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

        loadPlanViewModel.setErrorMessage(error);
        loadPlanViewModel.firePropertyChanged();
    }
}
