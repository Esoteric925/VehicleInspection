package se.kth.iv1201.vehicleInspection.model;

import java.util.Date;

/**
 * Represents an inspection for a specific vehicle
 */
public class CreditCard {

    private int pin;
    private String number;
    private String holder;
    private Date expiryDate;
    private int CVC;

    /**
     * Creates an instance of an credit card
     *
     * @param pin for specified creditcard
     * @param number for specified creditcard
     * @param holder for specified creditcard
     * @param expiryDate for specified creditcard
     * @param CVC for specified creditcard
     */
    public CreditCard(int pin, String number, String holder, Date expiryDate, int CVC){

        this.pin = pin;
        this.number = number;
        this.holder = holder;
        this.expiryDate = expiryDate;
        this.CVC = CVC;

    }

    /**
     *
     * @return the pin number for specified credit card
     */
    public Integer getPin(){
        return pin;
    }

    /**
     *
     * @return the card number for specified credit card
     */
    public String getNumber(){
        return number;
    }

    /**
     *
     * @return the holder of the specified credit card
     */
    public String getHolder(){
        return holder;
    }

    /**
     *
     * @return the expiry date for specified credit card
     */
    public Date getExpiryDate(){
        return expiryDate;
    }

    /**
     *
     * @return the CVC number for specified credit card
     */
    public Integer getCVC(){
        return CVC;
    }
}
