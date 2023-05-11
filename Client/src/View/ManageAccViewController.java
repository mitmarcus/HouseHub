package View;

import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import ViewModel.ManageAccViewModel;



public class ManageAccViewController extends ViewController{
    private ManageAccViewModel viewModel;

    @FXML private TextField username;
  @FXML private TextField password;
  @FXML private TextField firstname;
  @FXML private TextField lastname;
  @FXML private TextField phonenumber;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (ManageAccViewModel) viewModel;
        this.root = root;
        this.username.textProperty().bind(((ManageAccViewModel) viewModel).getUsernameProperty());
        this.password.textProperty().bindBidirectional(((ManageAccViewModel) viewModel).getPasswordProperty());
        this.firstname.textProperty().bindBidirectional(((ManageAccViewModel) viewModel).getFirstnameProperty());
        this.lastname.textProperty().bindBidirectional(((ManageAccViewModel) viewModel).getLastnameProperty());
        this.phonenumber.textProperty().bindBidirectional(((ManageAccViewModel) viewModel).getPhoneNumberProperty());
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

  @FXML public void goBack(){
        viewHandler.openView("main");
  }

  @FXML public void update(){
      if(viewModel.update()==true){
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle(" Successful");
        successAlert.setHeaderText("Your updated your account" );
        successAlert.showAndWait();
      }
      else {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle(" ERROR");
        successAlert.setHeaderText("Can not have null fields or less than 3 characters");
        successAlert.showAndWait();
      }
  }
}
