package se.kth.iv1201.vehicleInspection.integration;

/**
 * Represents the garage where the inspections are being held
 */
public class Garage {
    /**
     * Closes the door to the customer
     */
    public String closeDoor(){

        return "Garage is closing the door";
    }

    /**
     * Opens the door to the customer
     */
    public String openDoor(){
        return "Garage is opening the door";
    }

    /**
     * Let the next customer in to the garage
     */
    public String nextCustomer(){

        return "Garage is showing next queue number and letting the customer in";
    }
}
