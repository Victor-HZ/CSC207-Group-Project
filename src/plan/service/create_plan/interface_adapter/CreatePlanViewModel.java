package plan.service.create_plan.interface_adapter;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class CreatePlanViewModel extends ViewModel {
    public CreatePlanViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
