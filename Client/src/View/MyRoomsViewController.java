package View;

import Model.Room;
import ViewModel.MyRoomsViewModel;
import ViewModel.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class MyRoomsViewController extends ViewController {
    private MyRoomsViewModel viewModel;

    @FXML
    private TableView<MyRoomsViewModel> roomsTable;
    @FXML
    private TableColumn<MyRoomsViewModel, String> roomId;
    @FXML
    private TableColumn<MyRoomsViewModel, String> bedrooms;
    @FXML
    private TableColumn<MyRoomsViewModel, String> price;
    @FXML
    private TableColumn<MyRoomsViewModel, String> address;
    @FXML
    private TableColumn<MyRoomsViewModel, Boolean> reserved;


    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel,
                     Region root) {
        this.viewModel = (MyRoomsViewModel) viewModel;
        this.root = root;
        this.viewHandler = viewHandler;

        roomsTable.setItems(((MyRoomsViewModel) viewModel).getAll());
        roomId.setCellValueFactory(
                cellData -> cellData.getValue().getRoomIdProperty());
        bedrooms.setCellValueFactory(
                cellData -> cellData.getValue().getBedroomsProperty());
        price.setCellValueFactory(
                cellData -> cellData.getValue().getPriceProperty());
        address.setCellValueFactory(
                cellData -> cellData.getValue().getAddressProperty());
        reserved.setCellValueFactory(cellData -> cellData.getValue().getReservedProperty());
    }


    @Override
    public void reset() {
        viewModel.clear();
    }

    @FXML
    public void goBack() {
        viewHandler.openView("manageAcc");
    }


    @FXML
    public void remove() {
        viewModel.setSelectedRoom(roomsTable.getSelectionModel().getSelectedItem());
        viewModel.removeRoom();
    }
}
