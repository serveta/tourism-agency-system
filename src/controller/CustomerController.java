package controller;

import model.Customer;

public class CustomerController {
    private Customer customer;

    public CustomerController() {
        this.customer = new Customer();
    }

    public boolean addCustomer(int reservationId, int idNumber, String firstName, String lastName) {
        // Reservation control!!!!
        if(customer.add(reservationId,idNumber,firstName,lastName)){
            System.out.println(" +" + firstName + " was added.");
            return true;
        } else {
            System.out.println(" *Error occurred. (customer add)");
            return false;
        }
    }
}
