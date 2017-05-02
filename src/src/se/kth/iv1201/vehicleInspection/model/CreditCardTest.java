package se.kth.iv1201.vehicleInspection.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by araxi on 2017-05-01.
 */
public class CreditCardTest {

    CreditCard creditCard;
    @Before
    public void setUp() throws Exception {

        creditCard = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);

    }

    @Test
    public void getPin() throws Exception {
        Integer pin = 2222;
        assertEquals("get pin matches",creditCard.getPin(), pin);
    }

    @Test
    public void getNumber() throws Exception {
        String number = "1234 5678 9101 1213";
        assertEquals("get number matches",creditCard.getNumber(), number);

    }

    @Test
    public void getHolder() throws Exception {
        String holder = "Anna Panna";
        assertEquals("get holder matches",creditCard.getHolder(), holder);
    }

    @Test
    public void getExpiryDate() throws Exception {
        Date expiryDate = new Date();
        assertEquals("get expiry date matches",creditCard.getExpiryDate(), expiryDate);
    }

    @Test
    public void getCVC() throws Exception {
        Integer CVC = 322;
        assertEquals("get CVC matches",creditCard.getCVC(), CVC);
    }

}