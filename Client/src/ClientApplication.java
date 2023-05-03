import ModelClient.ModelClient;
import ModelClient.ModelManagerClient;
import Networking.RmiClient;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientApplication extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    RmiClient client = new RmiClient();
    ModelClient model = new ModelManagerClient();

    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
