package ViewModel;

import ModelClient.ModelClient;

public class ViewModelFactory
{
  private ShowRoomsViewModel showRoomsViewModel;
  private MainMenuViewModel mainMenuViewModel;
  private DetailsViewModel detailsViewModel;
  private ViewState viewState;


  public ViewModelFactory (ModelClient model)
  {
    this.viewState = new ViewState();
    this.showRoomsViewModel = new ShowRoomsViewModel(model,viewState);
    this.mainMenuViewModel = new MainMenuViewModel(model, viewState);
    this.detailsViewModel = new DetailsViewModel(model, viewState);
  }

  public ShowRoomsViewModel getShowRoomsViewModel()
  {
    return showRoomsViewModel;
  }
  public  MainMenuViewModel getMainMenuViewModel(){
    return mainMenuViewModel;
  }

  public DetailsViewModel getDetailsViewModel() {
    return detailsViewModel;
  }
}
