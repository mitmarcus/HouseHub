package ViewModel;

import Model.ModelClient;
import Model.Rating;
import Model.Room;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.swing.text.View;

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
        String room = model.getRoomByAnnouncement(viewState.getId()).getRoomId();
        String username = viewState.getUsername();
        System.out.println("Room check in rating view model " + room);
        Rating rating1 = new Rating(rating, username, room);

        model.addRating(rating1);
    }

    public void clear() {
        rating.setValue(null);
    }

}
