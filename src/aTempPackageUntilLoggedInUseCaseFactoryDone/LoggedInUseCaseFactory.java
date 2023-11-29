package aTempPackageUntilLoggedInUseCaseFactoryDone;

import plan.service.create_plan.CreatePlanInputBoundary;
import plan.service.create_plan.CreatePlanInteractor;
import plan.service.create_plan.CreatePlanOutputBoundary;
import plan.service.create_plan.interface_adapter.CreatePlanController;
import plan.service.create_plan.interface_adapter.CreatePlanPresenter;
import plan.service.load_plan.LoadPlanInputBoundary;
import plan.service.load_plan.LoadPlanInteractor;
import plan.service.load_plan.LoadPlanOutputBoundary;
import plan.service.load_plan.interface_adapter.LoadPlanController;
import plan.service.load_plan.interface_adapter.LoadPlanPresenter;
import plan.service.main_view_models.EditorViewModel;
import plan.service.main_view_models.StartUpViewModel;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import view.LoggedInView;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.io.IOException;

public class LoggedInUseCaseFactory {

    /** Prevent instantiation. */
    private LoggedInUseCaseFactory() {}

    public static LoggedInView create(ViewManagerModel viewManagerModel, LoggedInViewModel loggedinViewModel, StartUpViewModel startupViewModel, EditorViewModel editorViewModel) {

        try {
            CreatePlanController createController = createCreateUseCase(viewManagerModel, loggedinViewModel, editorViewModel);
            LoadPlanController loadController = createLoadUseCase(viewManagerModel, loggedinViewModel, editorViewModel);
            return new LoggedInView(loggedinViewModel, viewManagerModel, startupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static CreatePlanController createCreateUseCase(ViewManagerModel viewManagerModel, LoggedInViewModel loggedinViewModel, EditorViewModel editorViewModel) throws IOException {

        CreatePlanOutputBoundary createOutputBoundary = new CreatePlanPresenter();

        CreatePlanInputBoundary createInteractor = new CreatePlanInteractor();

        return new CreatePlanController(createInteractor);
    }

    private static LoadPlanController createLoadUseCase(ViewManagerModel viewManagerModel, LoggedInViewModel loggedinViewModel, EditorViewModel editorViewModel) throws IOException {
        LoadPlanOutputBoundary loadOutputBoundary = new LoadPlanPresenter();

        LoadPlanInputBoundary loadInteractor = new LoadPlanInteractor();

        return new LoadPlanController();
    }
}