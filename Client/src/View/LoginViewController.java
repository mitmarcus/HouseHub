package View;

import ViewModel.MainMenuViewModel;
import ViewModel.ViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

import ViewModel.LoginViewModel;


public class LoginViewController extends ViewController{
    private LoginViewModel viewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler viewHandler, ViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = (LoginViewModel) viewModel;
        this.root = root;
    }

    @Override
    public void reset() {
        viewModel.clear();
    }
}
