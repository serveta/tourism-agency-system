package controller;

import model.Hotel;
import model.Search;

import java.sql.Date;
import java.util.ArrayList;

public class SearchController {

    public SearchController() {}

    public ArrayList<Hotel> searchHotelBySeasonEnd(Date date) {
        Search search = new Search();
        return search.searchHotelBySeasonEnd(date);
    }
}
