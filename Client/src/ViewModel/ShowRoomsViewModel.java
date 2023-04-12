package ViewModel;

import Model_Client.ModelClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowRoomsViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;
  private ObservableList<String> list;

  public ShowRoomsViewModel(ModelClient model,ViewState viewState)
  {
    this.model =model;
    this.viewState = viewState;
    list = FXCollections.observableArrayList();
    list.add("Marcus");
    list.add("Ricardo");
    list.add("Nuri");
    list.add("Duarte");
  }

  @Override public void clear()
  {

  }
  public ObservableList<String> getList()
  {
    return list;
  }
}
