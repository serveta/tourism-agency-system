package view.customer;

import controller.SearchController;
import model.Hotel;

import java.sql.Date;

public class SearchGUI {

    private SearchController searchController;

    public SearchGUI() {
        this.searchController = new SearchController();

        Date date = Date.valueOf("2022-12-11");
        for (Hotel hotel : searchController.searchHotelBySeasonEnd(date)){
            System.out.println(" +" + hotel.getName());
        }
    }
}
