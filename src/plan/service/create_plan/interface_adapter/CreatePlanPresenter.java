package plan.service.create_plan.interface_adapter;

import apis.ActivitiesFetchInterface;
import apis.ticketmaster.TicketmasterAPI;
import apis.tripAdvisor.TripAdvisorAPI;
import app.EditorUseCaseFactory;
import app.Main;
import plan.entity.address.Address;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;
import plan.service.create_plan.CreatePlanOutputBoundary;
import plan.service.create_plan.CreatePlanOutputData;
import plan.service.generate_report.interface_adapter.GenerateReportViewModel;
import plan.service.main_view_models.EditorViewModel;
import user.entity.User;
import user.service.logged_in.interface_adaper.LoggedInState;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import view.EditorView;
import view.interface_adapter.ViewManagerModel;

import java.util.ArrayList;

public class CreatePlanPresenter implements CreatePlanOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    private final EditorViewModel editorViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreatePlanPresenter(LoggedInViewModel loggedInViewModel,
                               EditorViewModel editorViewModel,
                               ViewManagerModel viewManagerModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.editorViewModel = editorViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareEditorView(CreatePlanOutputData result) {
        // Switch to editor view from logged in view
        LoggedInState loggedInState = loggedInViewModel.getState();
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        Plan plan = result.getPlan();
        Address address = result.getAddress();
        User user = result.getUser();

        ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces = new ArrayList<>();
        activitiesFetchInterfaces.add(new TicketmasterAPI());
        activitiesFetchInterfaces.add(new TripAdvisorAPI());
        EditorView editorView = EditorUseCaseFactory.create(viewManagerModel, editorViewModel, new GenerateReportViewModel(), activitiesFetchInterfaces, plan, address, user);
        Main.addNewView(editorView, editorView.viewName);

        this.viewManagerModel.setActiveView(editorViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setCreatePlanError(error);
        loggedInViewModel.firePropertyChanged();
    }
}
