package se.kth.iv1201.vehicleInspection.integration;

/**
 * Represents the garage where the inspections are being held
 */
public class Garage {
    /**
     * Closes the door to the customer
     */
    public void closeDoor(){
        System.out.println("Garage is closing the door");
    }

    /**
     * Opens the door to the customer
     */
    public void openDoor(){ System.out.println("Garage is opening the door"); }

    /**
     * Let the next customer in to the garage
     */
    public void nextCustomer(){ System.out.println("Garage is showing next queue number and letting the customer in");}
}
