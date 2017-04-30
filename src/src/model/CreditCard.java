package model;

import java.util.Date;

/**
 * Created by Amir on 2017-04-30.
 */
public class CreditCard {

    private int pin;
    private String number;
    private String holder;
    private Date expiryDate;
    private int CVC;


    public CreditCard(int pin, String number, String holder, Date expiryDate, int CVC){

        this.pin = pin;
        this.number = number;
        this.holder = holder;
        this.expiryDate = expiryDate;
        this.CVC = CVC;

    }

    public Integer getPin(){
        return pin;
    }

    public String getNumber(){
        return number;
    }

    public String getHolder(){
        return holder;
    }

    public Date getExpiryDate(){
        return expiryDate;
    }

    public Integer getCVC(){
        return CVC;
    }
}
