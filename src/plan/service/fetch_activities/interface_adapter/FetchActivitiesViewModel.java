package plan.service.fetch_activities.interface_adapter;

import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class FetchActivitiesViewModel extends ViewModel {
    public FetchActivitiesViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
