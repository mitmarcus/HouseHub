package View;

import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import ViewModel.DetailsViewModel;
import javafx.scene.text.Text;

public class DetailsViewController extends ViewController {
    private DetailsViewModel viewModel;

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
        viewModel.clear();
    }

    @FXML
    private void goBack() {
        viewHandler.openView("showRooms");
    }

    @FXML
    private void reserveButtonPressed() {
        // TODO: handle the reserve button click event
    }

    @Override
    public void reset() {

    }
}

