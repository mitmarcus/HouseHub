package ViewModel;

import Model.ModelClient;
import Model.Rating;
import Model.Room;
import Model.User;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.swing.text.View;
import java.util.Optional;

public class RatingViewModel extends ViewModel {
    private ViewState viewState;
    private ModelClient model;
    private StringProperty rating;

    public RatingViewModel(ModelClient model, ViewState viewState)
    {
        this.model = model;
        this.viewState = viewState;
        this.rating = new SimpleStringProperty();
    }


    public StringProperty getRating()
    {
        return rating;
    }

    public void addRating(int rating)
    {
        User user = model.getUserByUsername(viewState.getUsername());
        Room room = model.getRoomById(viewState.getId());
        Rating rating1 = new Rating(rating, user, room);
        boolean hasUserRated = model.hasUserRated(user.getUsername(),room.getRoomId());


        if (hasUserRated==false)
        {
            model.addRating(rating1);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR");
            alert.setHeaderText("You already rated this room");
            Optional<ButtonType> result = alert.showAndWait();
            System.out.println("has already rated");
        }
    }

    public void clear() {
        rating.setValue(null);
    }

}
