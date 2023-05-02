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
    this.list = FXCollections.observableArrayList();
    this.selectedObject = new SimpleStringProperty();
    clear();
  }

  @Override public void clear()
  {
    for (int i = 0; i < model.getAllRooms().size();i++)
    {
      list.add(model.getAllRooms().get(i).getAnnouncement());
    }
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

  public void roomDetails() {
    viewState.setId(selectedObject.get());
  }


}
