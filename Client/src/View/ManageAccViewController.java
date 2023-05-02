package View;

import ViewModel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import ViewModel.ManageAccViewModel;



public class ManageAccViewController extends ViewController{
    private ManageAccViewModel viewModel;

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

  @FXML public void goBack(){
        viewHandler.openView("main");
  }
}
