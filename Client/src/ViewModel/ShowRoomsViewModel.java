package ViewModel;

import ModelClient.ModelClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowRoomsViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;
  private ObservableList<String> list;

  public ShowRoomsViewModel(ModelClient model,ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    list = FXCollections.observableArrayList();
    list.add("Room in horsens close to the city center");
    list.add("Room in horsens close to via university collegue");
    list.add("Apartment for 2 next to lovbjerg");
    list.add("Room for cheap price close to fitnessX");
  }

  @Override public void clear()
  {

  }
  public ObservableList<String> getList()
  {
    return list;
  }
}
