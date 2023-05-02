package View;

import ModelClient.Reservation;
import ViewModel.ViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import ViewModel.DetailsViewModel;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class DetailsViewController extends ViewController {
    private DetailsViewModel viewModel;
    @FXML
    private DatePicker fromDate = new DatePicker();

    @FXML
    private DatePicker toDate = new DatePicker();

    @FXML
    private ImageView cancelButton;

    @FXML
    private TextField price;

    @FXML
    private TextField roomSize;

    @FXML
    private TextField roomAddress;
    @FXML
    private TextField numberOfRooms;

    @FXML
    private Button reserveButton;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (DetailsViewModel) viewModel;
        this.root = root;
        this.price.textProperty().bind(((DetailsViewModel) viewModel).getPriceProperty());
        this.numberOfRooms.textProperty().bind(((DetailsViewModel) viewModel).getNumberOfRoomsProperty());
        this.roomAddress.textProperty().bind(((DetailsViewModel) viewModel).getRoomAddressProperty());
        this.roomSize.textProperty().bind(((DetailsViewModel) viewModel).getRoomSizeProperty());
        this.toDate.valueProperty().bindBidirectional(((DetailsViewModel) viewModel).getEndDate());
        this.fromDate.valueProperty().bindBidirectional(((DetailsViewModel) viewModel).getStartDate());


        viewModel.clear();
    }

    @FXML
    private void goBack() {
        viewHandler.openView("showRooms");
    }

    @FXML
    private void reserveButtonPressed() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to reserve from " + fromDate.getValue() + " to " + this.toDate.getValue() + "?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            viewModel.addReservation(fromDate.getValue(),toDate.getValue());
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Reservation Successful");
            successAlert.setHeaderText("Your reservation from " + fromDate.getValue() + " to " + toDate.getValue() + " has been made successfully.");
            successAlert.showAndWait();
        }
        viewHandler.openView("showRooms");
    }

    @Override
    public void reset() {

    }
}

