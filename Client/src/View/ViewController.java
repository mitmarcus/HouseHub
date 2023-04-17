package View;

import ViewModel.ViewModel;
import javafx.scene.layout.Region;

public abstract class ViewController
{
  protected Region root;

  protected ViewHandler viewHandler;
  public abstract  void init(ViewHandler viewHandler, ViewModel viewModel, Region root);

  public Region getRoot(){
    return root;
  }
  public abstract void reset();

}

