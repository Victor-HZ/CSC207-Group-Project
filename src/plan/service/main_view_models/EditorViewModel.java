package plan.service.main_view_models;

import view.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class EditorViewModel extends ViewModel {
    public EditorViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
