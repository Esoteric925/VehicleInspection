package se.kth.iv1201.vehicleInspection.model;

/**
 * Represents a cash register to be able to store cash payments
 */
public class CashRegister {

    public double change(){
        return 0;
    }

    /**
     * Is the payment for a specified inspection
     * @param cost the cost for the inspection that the customer has to pay
     */
    public void payment(double cost){
        System.out.println("Payment by cash done in cash registry with cost " + cost);
    }

}
