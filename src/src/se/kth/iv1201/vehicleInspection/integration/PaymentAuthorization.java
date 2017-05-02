package se.kth.iv1201.vehicleInspection.integration;

import se.kth.iv1201.vehicleInspection.model.CreditCard;

/**
 * Represents the external payment authorization for payment with credit card
 */
public class PaymentAuthorization {

    /**
     * Authorizes the credit card payment (in this case it always approves payment)
     * @param cost the cost for the specified inspection
     * @param card the credit card for the customer that pays for the specified inspection
     * @return
     */
    public boolean authorizePaymentCreditCard(CreditCard card, double cost){
        return true;
    }
}
