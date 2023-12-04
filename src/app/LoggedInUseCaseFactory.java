package app;

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

public class LoggedInUseCaseFactory {
    private LoggedInUseCaseFactory () {}

    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            StartUpViewModel startUpViewModel,
            EditorViewModel editorViewModel){
        CreatePlanController createPlanController = createCreatePlanController(loggedInViewModel, editorViewModel, viewManagerModel);
        LoadPlanController loadPlanController = createLoadPlanController(loggedInViewModel, editorViewModel, viewManagerModel);
        return new LoggedInView(loggedInViewModel, viewManagerModel, startUpViewModel, createPlanController, loadPlanController);
    }

    private static CreatePlanController createCreatePlanController(LoggedInViewModel loggedInViewModel, EditorViewModel editorViewModel, ViewManagerModel viewManagerModel){
        CreatePlanOutputBoundary createPlanOutputBoundary = new CreatePlanPresenter(loggedInViewModel, editorViewModel, viewManagerModel);
        CreatePlanInputBoundary createPlanInteractor = new CreatePlanInteractor(createPlanOutputBoundary);
        return new CreatePlanController(createPlanInteractor);

    }

    private static LoadPlanController createLoadPlanController(LoggedInViewModel loggedInViewModel, EditorViewModel editorViewModel, ViewManagerModel viewManagerModel){
        LoadPlanOutputBoundary loadPlanOutputBoundary = new LoadPlanPresenter(viewManagerModel, loggedInViewModel, editorViewModel);
        LoadPlanInputBoundary loadPlanInteractor = new LoadPlanInteractor(loadPlanOutputBoundary);
        return new LoadPlanController(loadPlanInteractor);
    }
}
