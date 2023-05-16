package ViewModel;

import Model.ModelClient;
import Model.Rating;
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

    public boolean addRating(int rating)
    {
        String room = model.getRoomById(viewState.getId()).getRoomId();
        String user = model.getUserByUsername(viewState.getUsername()).getUsername();
        Rating rating1 = new Rating(rating,user,room);

        model.addRating(rating1);
        return true;
    }

    public void clear() {
        rating.setValue(null);
    }




}
