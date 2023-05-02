package View;

import ModelClient.Reservation;
import ViewModel.ViewModel;
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
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

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
        this.fromDate.dayCellFactoryProperty().bind(((DetailsViewModel) viewModel).getStartDate().dayCellFactoryProperty());
        this.toDate.dayCellFactoryProperty().bind(((DetailsViewModel) viewModel).getEndDate().dayCellFactoryProperty());
        viewModel.clear();
    }

    @FXML
    private void goBack() {
        viewHandler.openView("showRooms");
    }

    @FXML
    private void reserveButtonPressed() {
        LocalDate startDate = fromDate.getValue();
        LocalDate endDate = toDate.getValue();

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("Are you sure you want to reserve from " + startDate + " to " + endDate + "?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            viewModel.addReservation(startDate, endDate);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Reservation Successful");
            successAlert.setHeaderText("Your reservation from " + startDate + " to " + endDate + " has been made successfully.");
            successAlert.showAndWait();
        }
        viewHandler.openView("showRooms");
    }

    @Override
    public void reset() {

    }
}

