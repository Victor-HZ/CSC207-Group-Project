package app;

import apis.ActivitiesFetchInterface;
import plan.service.add_activity.AddActivityInputBoundary;
import plan.service.add_activity.AddActivityInteractor;
import plan.service.add_activity.AddActivityOutputBoundary;
import plan.service.add_activity.interface_adapter.AddActivityController;
import plan.service.add_activity.interface_adapter.AddActivityPresenter;
import plan.service.delete_activity.DeleteActivityInputBoundary;
import plan.service.delete_activity.DeleteActivityInteractor;
import plan.service.delete_activity.DeleteActivityOutputBoundary;
import plan.service.delete_activity.interface_adapter.DeleteActivityController;
import plan.service.delete_activity.interface_adapter.DeleteActivityPresenter;
import plan.service.fetch_activities.FetchActivitiesInputBoundary;
import plan.service.fetch_activities.FetchActivitiesInteractor;
import plan.service.fetch_activities.FetchActivitiesOutputBoundary;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesController;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesPresenter;
import plan.service.main_view_models.EditorViewModel;
import plan.service.save_plan.SavePlanInputBoundary;
import plan.service.save_plan.SavePlanInteractor;
import plan.service.save_plan.SavePlanOutputBoundary;
import plan.service.save_plan.interface_adapter.SavePlanController;
import plan.service.save_plan.interface_adapter.SavePlanPresenter;
import view.EditorView;
import view.interface_adapter.ViewManagerModel;

import java.io.IOException;
import java.util.ArrayList;

public class EditorUseCaseFactory {

    private EditorUseCaseFactory() {}

    public static EditorView create(
            ViewManagerModel viewManagerModel,
            EditorViewModel editorViewModel,
            ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces){
        try {
            FetchActivitiesController fetchActivitiesController = createFetchActivitiesUseCase(activitiesFetchInterfaces);
            AddActivityController addActivityController = createAddActivityController(viewManagerModel, editorViewModel);
            DeleteActivityController deleteActivityController = createDeleteActivityController(viewManagerModel, editorViewModel);
            return new EditorView(editorViewModel, addActivityController, deleteActivityController, fetchActivitiesController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static AddActivityController createAddActivityController(ViewManagerModel viewManagerModel, EditorViewModel editorScreen){
        AddActivityOutputBoundary addActivityOutputBoundary = new AddActivityPresenter(viewManagerModel, editorScreen);
        AddActivityInputBoundary addActivityInteractor = new AddActivityInteractor(addActivityOutputBoundary);
        return new AddActivityController(addActivityInteractor);
    }

    private static DeleteActivityController createDeleteActivityController(ViewManagerModel viewManagerModel, EditorViewModel editorScreen){
        DeleteActivityOutputBoundary deleteActivityOutputBoundary = new DeleteActivityPresenter(viewManagerModel, editorScreen);
        DeleteActivityInputBoundary deleteActivityInteractor = new DeleteActivityInteractor(deleteActivityOutputBoundary);
        return new DeleteActivityController(deleteActivityInteractor);

    }

    private static FetchActivitiesController createFetchActivitiesUseCase(ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces) throws IOException {
        FetchActivitiesOutputBoundary fetchActivitiesOutputBoundary = new FetchActivitiesPresenter();
        FetchActivitiesInputBoundary fetchActivitiesInteractor = new FetchActivitiesInteractor(fetchActivitiesOutputBoundary, activitiesFetchInterfaces);
        return new FetchActivitiesController(fetchActivitiesInteractor);
    }

    private static SavePlanController createSavePlanUseCase(){
        SavePlanOutputBoundary savePlanOutputBoundary = new SavePlanPresenter();
        SavePlanInputBoundary savePlanInteractor = new SavePlanInteractor();
        return new SavePlanController();
    }
}
