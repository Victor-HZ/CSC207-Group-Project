package plan.service.create_plan.interface_adapter;

import plan.service.create_plan.CreatePlanOutputBoundary;
import plan.service.create_plan.CreatePlanOutputData;
import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.EditorViewModel;
import plan.service.main_view_models.StartUpState;
import plan.service.main_view_models.StartUpViewModel;
import user.entity.User;
import user.service.logged_in.interface_adaper.LoggedInState;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import user.service.signup.SignupOutputBoundary;
import user.service.signup.SignupOutputData;
import view.LoggedInView;
import view.ViewManager;
import view.interface_adapter.ViewManagerModel;

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
    public void prepareEditorView(CreatePlanOutputData user) {
        // Switch to editor view from start up view
        LoggedInState startUpState = loggedInViewModel.getState();
        this.loggedInViewModel.setState(startUpState);
        this.loggedInViewModel.firePropertyChanged();

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
