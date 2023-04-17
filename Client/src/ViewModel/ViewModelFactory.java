package ViewModel;

import ModelClient.ModelClient;

public class ViewModelFactory
{
  private ShowRoomsViewModel showRoomsViewModel;
  private MainMenuViewModel mainMenuViewModel;
  private ViewState viewState;


  public ViewModelFactory (ModelClient model)
  {
    this.viewState = new ViewState();
    this.showRoomsViewModel = new ShowRoomsViewModel(model,viewState);
    this.mainMenuViewModel = new MainMenuViewModel(model, viewState);
  }

  public ShowRoomsViewModel getShowRoomsViewModel()
  {
    return showRoomsViewModel;
  }
  public  MainMenuViewModel getMainMenuViewModel(){
    return mainMenuViewModel;
  }
}
