package app;

import apis.ActivitiesFetchInterface;
import plan.service.add_activity.AddActivityDataAccessInterface;
import plan.service.add_activity.AddActivityInputBoundary;
import plan.service.add_activity.AddActivityInteractor;
import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.add_activity.interface_adapter.AddActivityController;
import plan.service.add_activity.interface_adapter.AddActivityPresenter;
import plan.service.delete_activity.DeleteActivityDataAccessInterface;
import plan.service.delete_activity.DeleteActivityInputBoundary;
import plan.service.delete_activity.DeleteActivityInteractor;
import plan.service.delete_activity.DeleteActivityOutputBoundary;
import plan.service.delete_activity.interface_adapter.DeleteActivityController;
import plan.service.delete_activity.interface_adapter.DeleteActivityPresenter;
import plan.service.fetch_activities.FetchActivitiesDataAccessInterface;
import plan.service.fetch_activities.FetchActivitiesInputBoundary;
import plan.service.fetch_activities.FetchActivitiesInteractor;
import plan.service.fetch_activities.FetchActivitiesOutputBoundary;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesController;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesPresenter;
import plan.service.main_view_models.EditorViewModel;
import view.EditorView;
import view.interface_adapter.ViewManagerModel;
import view.interface_adapter.ViewModel;

import javax.swing.text.View;
import java.io.IOException;
import java.util.ArrayList;

public class EditorUseCaseFactory {

    private EditorUseCaseFactory() {}

    public static EditorView create(
            ViewManagerModel viewManagerModel,
            EditorViewModel editorViewModel,
            FetchActivitiesDataAccessInterface fetchActivitiesDataAccessInterface,
            DeleteActivityDataAccessInterface deleteActivityDataAccessInterface,
            AddActivityDataAccessInterface addActivityDataAccessInterface,
            ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces){
        try {
            FetchActivitiesController fetchActivitiesController = createFetchActivitiesUseCase(fetchActivitiesDataAccessInterface, activitiesFetchInterfaces);
            AddActivityController addActivityController = createAddActivityController(viewManagerModel, editorViewModel);
            DeleteActivityController deleteActivityController = createDeleteActivityController();
            return new EditorView(editorViewModel, addActivityController, deleteActivityController, fetchActivitiesController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static AddActivityController createAddActivityController(ViewManagerModel viewManagerModel, EditorViewModel editorScreen, AddActivityInputBoundary){
        AddActivityOutputBoundary addActivityOutputBoundary = new AddActivityPresenter(viewManagerModel, editorScreen);
        AddActivityInputBoundary addActivityInteractor = new AddActivityInteractor(addActivityOutputBoundary);
        return new AddActivityController(addActivityInteractor);
    }

    private static DeleteActivityController createDeleteActivityController(){
        DeleteActivityOutputBoundary deleteActivityOutputBoundary = new DeleteActivityPresenter();
        DeleteActivityInputBoundary deleteActivityInteractor = new DeleteActivityInteractor(deleteActivityOutputBoundary);
        return new DeleteActivityController(deleteActivityInteractor);

    }

    private static FetchActivitiesController createFetchActivitiesUseCase(FetchActivitiesDataAccessInterface fetchActivitiesDataAccessInterface, ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces) throws IOException {
        FetchActivitiesOutputBoundary fetchActivitiesOutputBoundary = new FetchActivitiesPresenter();
        FetchActivitiesInputBoundary fetchActivitiesInteractor = new FetchActivitiesInteractor(fetchActivitiesDataAccessInterface, fetchActivitiesOutputBoundary, activitiesFetchInterfaces);
        return new FetchActivitiesController(fetchActivitiesInteractor);
    }
}
