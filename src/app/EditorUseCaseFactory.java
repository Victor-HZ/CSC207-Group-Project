package app;

import apis.ActivitiesFetchInterface;
import plan.entity.address.Address;
import plan.entity.plan.Plan;
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
import plan.service.generate_report.GenerateReportInputBoundary;
import plan.service.generate_report.GenerateReportInteractor;
import plan.service.generate_report.GenerateReportOutputBoundary;
import plan.service.generate_report.interface_adapter.GenerateReportController;
import plan.service.generate_report.interface_adapter.GenerateReportPresenter;
import plan.service.generate_report.interface_adapter.GenerateReportViewModel;
import plan.service.main_view_models.EditorViewModel;
import plan.service.save_plan.SavePlanInputBoundary;
import plan.service.save_plan.SavePlanInteractor;
import plan.service.save_plan.SavePlanOutputBoundary;
import plan.service.save_plan.interface_adapter.SavePlanController;
import plan.service.save_plan.interface_adapter.SavePlanPresenter;
import user.entity.User;
import view.EditorView;
import view.interface_adapter.ViewManagerModel;
import view.interface_adapter.ViewModel;

import java.io.IOException;
import java.util.ArrayList;

public class EditorUseCaseFactory {

    private EditorUseCaseFactory() {}

    public static EditorView create(
            ViewManagerModel viewManagerModel,
            EditorViewModel editorViewModel,
            GenerateReportViewModel generateReportViewModel,
            ArrayList<ActivitiesFetchInterface> activitiesFetchInterfaces,
            Plan plan,
            Address address,
            User user){
        try {
            FetchActivitiesController fetchActivitiesController = createFetchActivitiesUseCase(activitiesFetchInterfaces);
            AddActivityController addActivityController = createAddActivityController(viewManagerModel, editorViewModel);
            DeleteActivityController deleteActivityController = createDeleteActivityController(viewManagerModel, editorViewModel);
            GenerateReportController generateReportController = createGenerateReportController(viewManagerModel, generateReportViewModel);
            SavePlanController savePlanController = createSavePlanUseCase(editorViewModel);
            return new EditorView(editorViewModel, addActivityController, deleteActivityController, fetchActivitiesController, generateReportController, savePlanController, plan, address, user);
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

    private static SavePlanController createSavePlanUseCase(EditorViewModel editorViewModel){
        SavePlanOutputBoundary savePlanOutputBoundary = new SavePlanPresenter(editorViewModel);
        SavePlanInputBoundary savePlanInteractor = new SavePlanInteractor(savePlanOutputBoundary);
        return new SavePlanController(savePlanInteractor);
    }

    private static GenerateReportController createGenerateReportController(ViewManagerModel viewManagerModel, GenerateReportViewModel generateReportViewModel){
        GenerateReportOutputBoundary generateReportOutputBoundary = new GenerateReportPresenter(viewManagerModel, generateReportViewModel);
        GenerateReportInputBoundary generateReportInteractor = new GenerateReportInteractor(generateReportOutputBoundary);
        return new GenerateReportController(generateReportInteractor);
    }
}
