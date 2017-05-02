package se.kth.iv1201.vehicleInspection.integration;

import se.kth.iv1201.vehicleInspection.model.CreditCard;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.List;

/**
 * Represents a printer
 */
public class Printer {

    /**
     * Prints receipt for cash payment
     * @param cost the cost for the specified inspection
     */
    public String printCashReceipt(double cost){

        return "Payment " + cost;
    }

    /**
     *Prints the result for the specified inspection
     * @param inspectedParts is a list of all the inspected items
     */
    public void printInspectionResult(List<InspectionItem> inspectedParts){
        System.out.println("The receipt for the inspection is: ");
        for(InspectionItem item : inspectedParts){
            System.out.println("The item is: " + item.getItemName() + " and status: " + item.getStatus());
        }
        System.out.println();

    }

    /**
     * Prints the receipt for payment with credit card
     * @param cost the cost for the specified inspection
     * @param card the credit card for the customer that pays for the specified inspection
     */
    public void printCreditCardReceipt(double cost, CreditCard card){
        System.out.println("Card holder: " + card.getHolder() );
        System.out.println("Payment: " +  cost);
    }
}
