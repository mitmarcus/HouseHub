package ViewModel;

import Model_Client.ModelClient;

public class ShowRoomsViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;

  public ShowRoomsViewModel(ModelClient model,ViewState viewState)
  {
    this.model =model;
    this.viewState = viewState;
  }

  @Override public void clear()
  {

  }
}
