package ViewModel;

import Model.ModelClient;

public class LoginViewModel extends ViewModel{
    private ModelClient model;
    private ViewState viewState;
    public LoginViewModel(ModelClient model, ViewState viewState){
        this.model = model;
        this.viewState = viewState;
    }
    @Override
    public void clear() {

    }
}
