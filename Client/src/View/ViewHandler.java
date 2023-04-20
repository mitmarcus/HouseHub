package View;

import ViewModel.ViewModel;
import ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class ViewHandler {
    private Region root;
    private Stage primaryStage;
    private Scene currentScene;
    private ViewModelFactory viewModelFactory;
    private ViewController showRoomsViewController;
    private ViewController mainMenuViewController;
    private ViewController detailsViewController;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("mainMenu");
    }

    public void closeView() {
        primaryStage.close();
    }

    public void openView(String id) {
        switch (id) {
            case "showRooms":
                showRoomsViewController = loadViewController("/Fxml/RoomListView.fxml", showRoomsViewController, viewModelFactory.getShowRoomsViewModel());
                break;
            case "mainMenu":
                mainMenuViewController = loadViewController("/Fxml/MainMenu.fxml", mainMenuViewController, viewModelFactory.getMainMenuViewModel());
                break;
            case "details":
                detailsViewController = loadViewController("Details.fxml", detailsViewController, viewModelFactory.getDetailsViewModel());
                break;

        }
        currentScene.setRoot(root);


        String title = "HouseHub";

        if (root.getUserData() != null) {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);

        primaryStage.setResizable(false);
        primaryStage.setScene(currentScene);
        primaryStage.getIcons().add(new Image("/Resources/Logo.png"));
        primaryStage.setResizable(true);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private ViewController loadViewController(String fxmlFile, ViewController viewController, ViewModel viewModel) {
        if (viewController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                this.root = loader.load();
                viewController = loader.getController();
                viewController
                        .init(this, viewModel, this.root);
                viewController.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            viewController.reset();
        }
        return viewController;
    }

}
