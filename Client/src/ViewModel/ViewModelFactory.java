package ViewModel;

import Model.ModelClient;

public class ViewModelFactory {
    private ShowRoomsViewModel showRoomsViewModel;
    private MainMenuViewModel mainMenuViewModel;
    private DetailsViewModel detailsViewModel;
    private LoginViewModel loginViewModel;
    private ManageAccViewModel manageAccViewModel;
    private ViewState viewState;
    private MyReservationsViewModel myReservationsViewModel;
    private ListYourRoomViewModel listYourRoomViewModel;
    private MyRoomsViewModel myRoomsViewModel;
    private RatingViewModel ratingViewModel;
    private MyNotificationsViewModel myNotificationsViewModel;

  /**
   * Constructor for ViewModelFactory
    * @param model ModelClient
   */
  public ViewModelFactory(ModelClient model) {
        this.viewState = new ViewState();
        this.listYourRoomViewModel = new ListYourRoomViewModel(model, viewState);
        this.showRoomsViewModel = new ShowRoomsViewModel(model, viewState);
        this.mainMenuViewModel = new MainMenuViewModel(model, viewState);
        this.detailsViewModel = new DetailsViewModel(model, viewState);
        this.loginViewModel = new LoginViewModel(model, viewState);
        this.manageAccViewModel = new ManageAccViewModel(model, viewState);
        this.myReservationsViewModel = new MyReservationsViewModel(model, viewState);
        this.myRoomsViewModel = new MyRoomsViewModel(model, viewState);
        this.ratingViewModel = new RatingViewModel(model, viewState);
        this.myNotificationsViewModel = new MyNotificationsViewModel(model, viewState);
    }

    public ShowRoomsViewModel getShowRoomsViewModel() {
        return showRoomsViewModel;
    }

    public MainMenuViewModel getMainMenuViewModel() {
        return mainMenuViewModel;
    }

    public DetailsViewModel getDetailsViewModel() {
        return detailsViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public ManageAccViewModel getManageAccViewModel() {
        return manageAccViewModel;
    }

    public MyReservationsViewModel getMyReservationsViewModel() {
        return myReservationsViewModel;
    }

    public ListYourRoomViewModel getListYourRoomViewModel() {
        return listYourRoomViewModel;
    }

    public MyRoomsViewModel getMyRoomsViewModel() {
        return myRoomsViewModel;
    }

    public RatingViewModel getRatingViewModel() {
        return ratingViewModel;
    }

    public MyNotificationsViewModel getMyNotificationsViewModel() {
        return myNotificationsViewModel;
    }
}
