package controller;

import model.Hotel;
import model.Search;

import java.sql.Date;
import java.util.ArrayList;

public class SearchController {

    public SearchController() {
    }

    public ArrayList<Hotel> searchHotelBySeasonEnd(Date startDate, Date endDate, String hotelAddress, String hotelName) {
        Search search = new Search();
        return search.searchHotelBySeasonEnd(startDate, endDate, hotelAddress, hotelName);
    }
}
