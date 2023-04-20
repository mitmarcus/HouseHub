package View;

import ModelClient.Room;
import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import ViewModel.DetailsViewModel;

public class DetailsViewController extends ViewController {
    private DetailsViewModel model;

    @FXML
    private TableView<Room> roomTable;

    @FXML
    private TableColumn<Room, String> priceColumn;

    @FXML
    private TableColumn<Room, String> addressColumn;

    @FXML
    private TableColumn<Room, Integer> sizeColumn;

    @FXML
    private TableColumn<Room, Integer> bedroomsColumn;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.model = (DetailsViewModel) viewModel;
        this.root = root;
        this.roomTable.setItems(((DetailsViewModel) viewModel).getList());

        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        bedroomsColumn.setCellValueFactory(new PropertyValueFactory<>("bedrooms"));
    }

    @Override
    public void reset() {

    }
}
