package controller;

import model.Customer;

public class CustomerController {
    private Customer customer;

    public CustomerController() {
        this.customer = new Customer();
    }

    public boolean addCustomer(int reservationId, int idNumber, String firstName, String lastName) {
        ReservationController reservationController = new ReservationController();
        if (reservationController.getFetchReservationById(reservationId) != null){
            if(customer.add(reservationId,idNumber,firstName,lastName)){
                System.out.println(" +" + firstName + " was added.");
                return true;
            } else {
                System.out.println(" *Error occurred. (customer add)");
                return false;
            }
        } else {
            System.out.println(" *Reservation not found!");
            return false;
        }
    }
}
