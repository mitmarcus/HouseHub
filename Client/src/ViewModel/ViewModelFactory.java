package ViewModel;

import Model_Client.ModelClient;

public class ViewModelFactory
{
  private ShowRoomsViewModel showRoomsViewModel;
  private ViewState viewState;


  public ViewModelFactory (ModelClient model)
  {
    this.viewState = new ViewState();
    this.showRoomsViewModel = new ShowRoomsViewModel(model,viewState);
  }

  public ShowRoomsViewModel getShowRoomsViewModel()
  {
    return showRoomsViewModel;
  }
}
