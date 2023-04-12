import Model_Client.ModelClient;
import Model_Client.ModelManagerClient;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientApplication extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    ModelClient model = new ModelManagerClient();

    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
