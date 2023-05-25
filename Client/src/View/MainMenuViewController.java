package View;


import ViewModel.MainMenuViewModel;
import ViewModel.ShowRoomsViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import javax.swing.*;

public class MainMenuViewController extends ViewController {
    private MainMenuViewModel viewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (MainMenuViewModel) viewModel;
        this.root = root;
    }


    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    public void handleSearchRooms(ActionEvent actionEvent) {
        viewHandler.openView("showRooms");
    }

    @FXML
    public void handleListYourRoom(ActionEvent actionEvent) {
        viewHandler.openView("listYourRoom");
    }

    @FXML
    public void handleManageProfile(ActionEvent actionEvent) {
        viewHandler.openView("manageAcc");
    }

    @FXML
    public void notifications(ActionEvent event) {
        viewHandler.openView("notifications");
    }

    public void handleLogout(ActionEvent actionEvent) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Logout Confirmation");
        confirmationDialog.setHeaderText("Are you sure you want to log out?");
        confirmationDialog.setContentText("Click OK to log out or Cancel to stay logged in.");

        // Show the confirmation dialog and wait for the user's response
        ButtonType response = confirmationDialog.showAndWait().orElse(ButtonType.CANCEL);

        // If the user clicked OK, proceed with the logout
        if (response == ButtonType.OK) {
            // Perform the necessary logout operations here

            // Open the main view
            viewHandler.openView("login");
        }
    }
}
