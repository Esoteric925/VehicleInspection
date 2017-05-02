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
        CreditCard card = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
        assertEquals("get pin matches",creditCard.getPin(), card.getPin());
    }

    @Test
    public void getNumber() throws Exception {
        CreditCard card = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
        assertEquals("get number matches",creditCard.getNumber(), card.getNumber());

    }

    @Test
    public void getHolder() throws Exception {
        CreditCard card = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
        assertEquals("get holder matches",creditCard.getHolder(), card.getHolder());
    }

    @Test
    public void getExpiryDate() throws Exception {
        CreditCard card = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
        assertEquals("get expiry date matches",creditCard.getExpiryDate(), card.getExpiryDate());
    }

    @Test
    public void getCVC() throws Exception {
        CreditCard card = new CreditCard(2222, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
        assertEquals("get CVC matches",creditCard.getCVC(), card.getCVC());
    }

}