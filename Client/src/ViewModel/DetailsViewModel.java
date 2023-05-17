package ViewModel;

import Model.*;
import Model.ModelClient;
import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class DetailsViewModel extends ViewModel {
    private ViewState viewState;
    private ModelClient model;
    private StringProperty price;
    private StringProperty roomSize;
    private StringProperty roomAddress;
    private StringProperty numberOfRooms;
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;
    private ArrayList<String> imagesPath = new ArrayList<>();
    private ArrayList<Image> images = new ArrayList<>() ;
    private int index=0;

    private StringProperty avgRating;


    public DetailsViewModel(ModelClient model, ViewState viewState) {
        this.model = model;
        this.viewState = viewState;
        this.price = new SimpleStringProperty();
        this.roomAddress = new SimpleStringProperty();
        this.roomSize = new SimpleStringProperty();
        this.numberOfRooms = new SimpleStringProperty();
        this.startDate = new SimpleObjectProperty<>();
        this.endDate = new SimpleObjectProperty<>();
        this.avgRating = new SimpleStringProperty();

    }

    public StringProperty getPriceProperty() {
        return price;
    }

    public StringProperty getRoomSizeProperty() {
        return roomSize;
    }

    public StringProperty getRoomAddressProperty() {
        return roomAddress;
    }

    public StringProperty getNumberOfRoomsProperty() {
        return numberOfRooms;
    }

    public ObjectProperty<LocalDate> getStartDate() {
        return startDate;
    }

    public ObjectProperty<LocalDate> getEndDate() {
        return endDate;
    }
    public StringProperty getAvgRating()
    {
        return avgRating;
    }

    public boolean addReservation(LocalDate startDate, LocalDate endDate) {
        Room room = model.getRoomByAnnouncement(viewState.getId());
        User user = model.getUserByUsername(viewState.getUsername());
        System.out.println(user.toString());
        Reservation reservation = new Reservation(user,startDate,endDate,room);
        model.addReservation(reservation);
        model.setRoomReserved(room);
            return true;
    }

    @Override
    public void clear() {
        imagesPath.clear();
        images.clear();
        getImagesPath();
        loadImageList();

        price.setValue("");
        roomAddress.setValue("");
        numberOfRooms.setValue("");
        roomSize.setValue("");
        avgRating.setValue(null);
        Room room = model.getRoomByAnnouncement(viewState.getId());


        this.price.setValue(room.getPrice());
        this.roomSize.setValue(room.getSize());
        this.numberOfRooms.setValue(room.getBedrooms());
        this.roomAddress.setValue(room.getAddress());
        this.avgRating.setValue(
            String.valueOf(model.getAvgRatingById(room.getRoomId())));

        this.startDate.setValue(null);
        this.endDate.setValue(null);
    }

    private void loadImageList(){
        images.clear();
        for (int i= 0 ; i < imagesPath.size();i++){
            images.add(new Image(new File(imagesPath.get(i)).toURI().toString()));
        }
    }

    public Image getImage(){
        Image image = null;
        if (index >= images.size())
            this.index = 0;
        image = images.get(index);
        index++;

        return image;
    }

    public Image mainImage(){
        if (imagesPath.size()==0)
        {
            return new Image(new File("Client/src/Resources/placeholder.jpg").toURI().toString());
        }
        return new Image(new File(imagesPath.get(0)).toURI().toString());
    }

    private void getImagesPath()
    {
        Room room = model.getRoomByAnnouncement(viewState.getId());
       String roomId = room.getRoomId();
        for (String path : model.getRoomImagesPaths(roomId))
        {
            imagesPath.add(path);
        }
    }

}
