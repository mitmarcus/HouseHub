package View;

import ViewModel.MainMenuViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

import ViewModel.ManageAccViewModel;


public class ManageAccViewController extends ViewController{
    private ManageAccViewModel viewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (ManageAccViewModel) viewModel;
        this.root = root;
    }

    @Override
    public void reset() {
        viewModel.clear();
    }

    public void goBack(ActionEvent actionEvent) {
        viewHandler.openView("main");
    }
}
