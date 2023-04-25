package View;

import ViewModel.ViewModel;
import javafx.scene.layout.Region;

public abstract class ViewController
{
  protected ViewHandler viewHandler;
  protected Region root;
  public abstract  void init(ViewHandler viewHandler, ViewModel viewModel, Region root);

  public Region getRoot(){
    return root;
  }
  public abstract void reset();

}

