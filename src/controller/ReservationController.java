package controller;

import model.Reservation;

public class ReservationController {
    private Reservation reservation;

    public ReservationController() {
        this.reservation = new Reservation();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public boolean addReservation(int hotelId, int room_id, int hostel_id) {
        if (reservation.add(hotelId, room_id, hostel_id)){
            System.out.println(" *Reservation was added.");
            return true;
        } else {
            System.out.println(" *Error occurred. (reservation add)");
            return false;
        }
    }

    public int getLastReservationId(){
        return getReservation().getLastReservationId();
    }
}
