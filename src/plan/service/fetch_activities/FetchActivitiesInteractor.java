package plan.service.fetch_activities;

import apis.ActivitiesFetchInterface;
import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FetchActivitiesInteractor implements FetchActivitiesInputBoundary {
    final FetchActivitiesOutputBoundary fetchActivitiesPresenter;
    final ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections;

    public FetchActivitiesInteractor(FetchActivitiesOutputBoundary fetchActivitiesPresenter, ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections){
        this.fetchActivitiesPresenter = fetchActivitiesPresenter;
        this.activitiesFetchInterfacesCollections = activitiesFetchInterfacesCollections;
    }

    @Override
    public void execute(DayInfo date, Address addresss) {
        ArrayList<Activity> activities = new ArrayList<>();
        for(ActivitiesFetchInterface fetcher : activitiesFetchInterfacesCollections){
            activities.addAll(fetcher.getEvents(addresss.getCity(), date));
        }
        if(!activities.isEmpty()){
            LocalDateTime time = LocalDateTime.now();
            FetchActivitiesOutputData fetchActivitiesOutputData = new FetchActivitiesOutputData(activities, false, time.toString());
            fetchActivitiesPresenter.prepareSuccessView(fetchActivitiesOutputData);
        } else {
            fetchActivitiesPresenter.prepareFailView("No activity fetched!");
        }
    }
}
