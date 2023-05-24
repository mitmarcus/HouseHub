package View;

import ViewModel.ViewModel;
import ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class ViewHandler {
    private Region root;
    private Stage primaryStage;
    private Scene currentScene;
    private Stage ratingStage;
    private Stage notificationsStage;
    private ViewModelFactory viewModelFactory;
    private ViewController showRoomsViewController;
    private ViewController mainMenuViewController;
    private ViewController detailsViewController;
    private ViewController loginViewController;
    private ViewController manageAccViewController;
    private ViewController myReservationsViewController;
    private ViewController listYourRoomViewController;
    private ViewController myRoomsViewController;
    private ViewController ratingController;

    private ViewController myNotificationsViewController;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("login");
    }

    public void closeView() {
        primaryStage.close();
    }

    /**
     * Loads the view with the given id.
     *
     * @param id the id of the view to be loaded.
     */
    public void openView(String id) {
        switch (id) {
            case "showRooms":
                showRoomsViewController = loadViewController("/Fxml/RoomListView.fxml", showRoomsViewController, viewModelFactory.getShowRoomsViewModel());
                break;
            case "main":
                mainMenuViewController = loadViewController("/Fxml/MainMenu.fxml", mainMenuViewController, viewModelFactory.getMainMenuViewModel());
                break;
            case "details":
                detailsViewController = loadViewController("/Fxml/Details.fxml", detailsViewController, viewModelFactory.getDetailsViewModel());
                break;
            case "login":
                loginViewController = loadViewController("/Fxml/Login.fxml", loginViewController, viewModelFactory.getLoginViewModel());
                break;
            case "manageAcc":
                manageAccViewController = loadViewController("/Fxml/ManageAcc.fxml", manageAccViewController, viewModelFactory.getManageAccViewModel());
                break;
            case "myReservations" :
                myReservationsViewController = loadViewController("/Fxml/MyReservation.fxml", myReservationsViewController, viewModelFactory.getMyReservationsViewModel());
                break;
            case "listYourRoom" :
                listYourRoomViewController = loadViewController("/Fxml/ListYourRoom.fxml", listYourRoomViewController,viewModelFactory.getListYourRoomViewModel());
                break;
            case "myRooms" :
                myRoomsViewController = loadViewController("/Fxml/MyRooms.fxml",myRoomsViewController,viewModelFactory.getMyRoomsViewModel());
                break;
            case "rating" :
                //ratingController = loadViewController("/Fxml/Rating.fxml", ratingController, viewModelFactory.getRatingViewModel());
                openRatingWindow();
                break;
            case "notifications" :
                myNotificationsViewController = loadViewController("/Fxml/MyNotifications.fxml",myNotificationsViewController,viewModelFactory.getMyNotificationsViewModel());
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
        primaryStage.setResizable(false);
        primaryStage.setScene(currentScene);
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
                viewController.init(this, viewModel, this.root);
                viewController.reset();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        root=viewController.getRoot();
        viewController.reset();
        return viewController;
        }

    private void openRatingWindow() {
        if (ratingStage == null) {
            ratingStage = new Stage();
            ratingStage.initModality(Modality.APPLICATION_MODAL);
            ratingStage.setTitle("Rate Room");
            ratingStage.getIcons().add(new Image("/Resources/Logo.png"));

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Fxml/Rating.fxml"));
            Parent ratingRoot;
            try {
                ratingRoot = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            ratingController = loader.getController();
            ratingController.init(this, viewModelFactory.getRatingViewModel(), root);

            Scene ratingScene = new Scene(ratingRoot);
            ratingStage.setScene(ratingScene);
        }

        ratingStage.showAndWait();
    }


    private void openNotificationsWindow() {
        if (notificationsStage == null) {
            notificationsStage = new Stage();
            notificationsStage.initModality(Modality.APPLICATION_MODAL);
            notificationsStage.setTitle("Notifications");
            notificationsStage.getIcons().add(new Image("/Resources/Logo.png"));

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Fxml/MyNotifications.fxml"));
            Parent notificationRoot;
            try {
                notificationRoot = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            myNotificationsViewController = loader.getController();
            myNotificationsViewController.init(this, viewModelFactory.getMyNotificationsViewModel(), root);

            Scene notificationScene = new Scene(notificationRoot);
            notificationsStage.setScene(notificationScene);
        }

        notificationsStage.showAndWait();
    }

    public void closeRatingWindow() {
        if (ratingStage != null) {
            ratingStage.close();
            ratingStage = null;
            ratingController = null;
        }
    }
}



