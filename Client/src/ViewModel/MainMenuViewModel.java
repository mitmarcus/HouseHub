package ViewModel;

import Model.ModelClient;

public class MainMenuViewModel extends ViewModel{
    private ModelClient model;
    private ViewState viewState;
    public MainMenuViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
    }
    @Override
    public void clear() {

    }
}
