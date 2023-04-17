package View;

<<<<<<< HEAD

=======
>>>>>>> main
import ViewModel.ViewModel;
import ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
<<<<<<< HEAD
=======
import javafx.scene.image.Image;
>>>>>>> main
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class ViewHandler
{
  private Region root;
  private Stage primaryStage;
  private Scene currentScene;
  private ViewModelFactory viewModelFactory;
  private ViewController showRoomsViewController;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView("showRooms");
  }

  public void closeView() {
    primaryStage.close();
  }

  public void openView(String id) {
    switch (id)
    {
      case "showRooms":
<<<<<<< HEAD
        showRoomsViewController = loadViewController("./Fxml/RoomListView.fxml",showRoomsViewController,viewModelFactory.getShowRoomsViewModel());
=======
        showRoomsViewController = loadViewController("/Fxml/RoomListView.fxml",showRoomsViewController,viewModelFactory.getShowRoomsViewModel());
>>>>>>> main
        break;
     /* case "menu":
        menuViewController = loadViewController("MenuView.fxml",menuViewController, viewModelFactory.getMenuViewModel());
        break;
      case "chess":
        chessViewController = loadViewController("ChessBoard.fxml",chessViewController, viewModelFactory.getChessViewModel());
        break;
        */
    }
    currentScene.setRoot(root);

<<<<<<< HEAD
    String title = "";
=======
    String title = "HouseHub";
>>>>>>> main
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
<<<<<<< HEAD
    primaryStage.setResizable(false);
    primaryStage.setScene(currentScene);
<<<<<<< Updated upstream
=======
    primaryStage.getIcons().add(new Image("/Resources/Logo.png"));
>>>>>>> Stashed changes
=======
    primaryStage.setResizable(true);
    primaryStage.setScene(currentScene);
    primaryStage.getIcons().add(new Image("/Resources/logo.png"));
>>>>>>> main
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }
  private ViewController loadViewController(String fxmlFile, ViewController viewController, ViewModel viewModel) {
    if (viewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        this.root = loader.load();
        viewController = loader.getController();
        viewController
            .init(this,viewModel, this.root);
        viewController.reset();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      viewController.reset();
    }
    return viewController;
  }

}
