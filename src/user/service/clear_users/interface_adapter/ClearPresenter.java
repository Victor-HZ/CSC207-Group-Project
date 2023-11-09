package user.service.clear_users.interface_adapter;


import interface_adapter.ViewManagerModel;
import user.service.clear_users.ClearOutputBoundary;
import user.service.clear_users.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {

    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ClearViewModel clearViewModel,
                          ViewManagerModel viewManagerModel){
        this.clearViewModel = clearViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        ClearState clearState = clearViewModel.getState();
        clearState.setUsernames(response.getUsernames());
        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(clearViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

//        String message = "";
//        for(String user : response.getUsernames()){
//            message = message + user + '\n';
//        }
//        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void prepareFailedView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setUsernameError(error);
        clearViewModel.firePropertyChanged();
    }
}
