package View;

import ViewModel.ViewModel;
import ViewModel.MyNotificationsViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

import javax.swing.text.View;
import java.util.Optional;

public class MyNotificationsViewController extends ViewController {

    @FXML private ListView<String> notificationListView;
    private MyNotificationsViewModel viewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (MyNotificationsViewModel) viewModel;
        this.notificationListView.setItems(((MyNotificationsViewModel) viewModel).getList());
        this.root = root;
    }

    @Override
    public void reset() {

    }

    @FXML
    private void goBack() {
        viewHandler.openView("");
    }

    @FXML
    public void removeButtonPressed() {
       /* int numberOfSelectedRows = notificationListView.getSelectionModel().getSelectedItems().size();
        if (numberOfSelectedRows == 1) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation");
            confirmationAlert.setHeaderText("Are you sure you want delete this notification? ");
            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                viewModel.removeNotification(notificationListView.getSelectionModel().getSelectedItem());
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle(" Successful");
                successAlert.setHeaderText("Notification deleted!" );
                successAlert.showAndWait();
            }


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("Please select a Notification");
            Optional<ButtonType> result = alert.showAndWait();
        }*/
    }


}
