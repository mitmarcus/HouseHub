package View;

import ModelClient.Room;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import ViewModel.DetailsViewModel;
import javafx.scene.text.Text;

public class DetailsViewController extends ViewController {
    private DetailsViewModel viewModel;

    @FXML
    private ImageView cancelButton;

    @FXML
    private Text roomPrice;

    @FXML
    private TextField roomSize;

    @FXML
    private TextField roomAddress;

    @FXML
    private Button reserveButton;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (DetailsViewModel) viewModel;
        this.root = root;
    }

    @FXML
    private void handleImageButton() {
        // TODO: handle the image button click event
    }

    @FXML
    private void reserveButtonPressed() {
        // TODO: handle the reserve button click event
    }

    @Override
    public void reset() {

    }
}

