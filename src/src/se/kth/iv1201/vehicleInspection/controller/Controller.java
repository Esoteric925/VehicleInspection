package se.kth.iv1201.vehicleInspection.controller;

import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1201.vehicleInspection.model.CashRegister;
import se.kth.iv1201.vehicleInspection.model.Inspection;
import se.kth.iv1201.vehicleInspection.integration.Garage;
import se.kth.iv1201.vehicleInspection.integration.PaymentAuthorization;
import se.kth.iv1201.vehicleInspection.integration.Printer;
import se.kth.iv1201.vehicleInspection.model.CreditCard;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.List;

/**
 * Represents the controller which acts as the intermediator between the view and the model
 */
public class Controller {

    Garage garage;
    Printer printer;
    Inspection inspection;
    InspectionRegistry inspectionRegistry;
    PaymentAuthorization paymentAuthorization;
    CashRegister cashRegister;


    /**
     * Creates an instance of the controller with all objects needed to be able to make business logic calls
     * @param garage
     * @param printer
     * @param cashRegister
     * @param inspectionRegistry
     * @param paymentAuthorization
     */
    public Controller(Garage garage, Printer printer, CashRegister cashRegister,
                      InspectionRegistry inspectionRegistry, PaymentAuthorization paymentAuthorization){

        this.garage = garage;
        this.printer = printer;
        this.cashRegister = cashRegister;
        this.inspectionRegistry = inspectionRegistry;
        this.paymentAuthorization = paymentAuthorization;
    }

    /**
     * Creates an inspection
     * @param regNr the registration number for the vehicle
     */
    public void createInspection(int regNr){
        Inspection inspection = new Inspection(regNr, getInspectionList(regNr), inspectionRegistry);
        this.inspection = inspection;
    }

    /**
     *
     * @param regNr the registration number for the vehicle
     * @return the list with the inspection items
     */
    public List<InspectionItem> getInspectionList(int regNr){
        return inspectionRegistry.getInspection(regNr);
    }



    /**
     * Initiates the inspection by making calls to the garage
     */
    public String openDoor(){

        return garage.openDoor();
    }

    public String nextCustomer(){
        return garage.nextCustomer();
    }

    /**
     * Closes the garage door
     */
    public String closeTheDoor(){

        return  garage.closeDoor();
    }

    /**
     * Checks the registration number for the vehicle that has an inspection. If it exists it calculates the cost for it
     * @param regNr the registration number for the vehicle
     * @return returns the cost for the found inspection
     */
    public double checkRegNr(int regNr){
       List<InspectionItem> foundInspection = inspectionRegistry.getInspection(regNr);
        double cost = 0;
        if(foundInspection != null){
            cost = inspection.calculateCost(foundInspection);
        }

        return cost;
    }

    /**
     *
     * @return the list of all parts that need to be inspected for the vehicle
     */
    public List<InspectionItem> checkWhatToInspect(){
         List<InspectionItem> inspectedParts = inspection.getInspectionParts();


        return inspectedParts;
    }

    /**
     * Stores result for an inspected item
     * @param inspectionItem the item that is inspected
     * @param status the status for the item to know if it has passed or not
     */
    public void storeItemResult(InspectionItem inspectionItem, boolean status){
            inspection.storeItemResult(inspectionItem, status);
    }


    /**
     * Represents payment with cash. It stores the cost in the cash register and prints the receipt to the customer
     * @param cost the cost for the inspection
     */
    public void payByCash(double cost){
        cashRegister.payment(cost);
        System.out.println("Printing receipt for payment by cash...");
        printer.printCashReceipt(cost);

    }

    /**
     * Represents payment with credit card. It checks if the payment was approved by the payment authorization and
     * prints out the receipt to the customer
     * @param creditCard
     * @param cost
     * @return
     */
    public boolean payByCard(CreditCard creditCard, double cost){
        boolean success = paymentAuthorization.authorizePaymentCreditCard(creditCard, cost);
        if(success == true){
            System.out.println("Your credit card payment has been approved, printing receipt...");
            printer.printCreditCardReceipt(cost, creditCard);
        }
        return success;
    }

    /**
     * Prints out the result after the inspection is done by the inspector
     * @param items the items that has been inspected
     */
    public void printInspectionResult(List<InspectionItem> items){
        printer.printInspectionResult(items);
    }


}
