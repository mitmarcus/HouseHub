package ViewModel;

import ModelClient.ModelClient;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ModelClient.Room;

public class ShowRoomsViewModel extends ViewModel
{
  private ViewState viewState;
  private ModelClient model;
  private ObservableList<String> list;
  private StringProperty selectedObject;

  public ShowRoomsViewModel(ModelClient model,ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    list = FXCollections.observableArrayList();
    this.selectedObject = new SimpleStringProperty();
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

  public void setSelectedObject(String id){
    this.selectedObject.set(id);
  }

  public void setId(String id)
  {
    viewState.setId(id);
  }


}
