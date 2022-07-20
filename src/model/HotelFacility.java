package model;

public class HotelFacility {
    int id;
    int hotelId;
    String facilityName;

    public HotelFacility(int id, int hotelId, String facilityName) {
        this.id = id;
        this.hotelId = hotelId;
        this.facilityName = facilityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
