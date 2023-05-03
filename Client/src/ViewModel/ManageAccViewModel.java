package ViewModel;

import Model.ModelClient;

public class ManageAccViewModel extends ViewModel{
    private ModelClient model;
    private ViewState viewState;
    public ManageAccViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
    }
    @Override
    public void clear() {

    }
}
