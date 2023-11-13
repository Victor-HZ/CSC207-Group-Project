package plan.service.fetch_activities;

import apis.ActivitiesFetchInterface;
import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

import java.util.ArrayList;

public class FetchActivitiesInteractor implements FetchActivitiesInputBoundary {
    final FetchActivitiesDataAccessInterface dataAccessObject;
    final FetchActivitiesOutputBoundary fetchActivitiesPresenter;
    final ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections;

    public FetchActivitiesInteractor(FetchActivitiesDataAccessInterface dataAccessObject, FetchActivitiesOutputBoundary fetchActivitiesPresenter, ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections){
        this.dataAccessObject = dataAccessObject;
        this.fetchActivitiesPresenter = fetchActivitiesPresenter;
        this.activitiesFetchInterfacesCollections = activitiesFetchInterfacesCollections;
    }

    @Override
    public void execute(DayInfo date, Address addresss) {
        ArrayList<Activity> activities = null;
        for(ActivitiesFetchInterface fetcher : activitiesFetchInterfacesCollections){
            activities.addAll(fetcher.getEvents(addresss.getCity(), date));
        }
        if(activities.size() != 0){
            FetchActivitiesOutputData fetchActivitiesOutputData = new FetchActivitiesOutputData(activities, false);
            fetchActivitiesPresenter.prepareSuccessView(fetchActivitiesOutputData);
        } else {
            fetchActivitiesPresenter.prepareFailView("No activity fetched!");
        }
    }
}
