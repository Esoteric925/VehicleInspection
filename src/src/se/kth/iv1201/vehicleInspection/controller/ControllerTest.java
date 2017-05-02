package se.kth.iv1201.vehicleInspection.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1201.vehicleInspection.integration.Garage;
import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1201.vehicleInspection.integration.PaymentAuthorization;
import se.kth.iv1201.vehicleInspection.integration.Printer;
import se.kth.iv1201.vehicleInspection.model.CashRegister;
import se.kth.iv1201.vehicleInspection.model.CreditCard;
import se.kth.iv1201.vehicleInspection.model.Inspection;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by araxi on 2017-05-02.
 */
public class ControllerTest {
    Garage garage;
    Printer printer;
    CashRegister cashRegister;
    PaymentAuthorization paymentAuthorization;
    Controller controller;
    List<InspectionItem> inspectionItems;
    Inspection inspection;
    InspectionRegistry inspectionRegistry;



    @Before
    public void setUp() throws Exception {

        garage = new Garage();
        printer = new Printer();
        cashRegister = new CashRegister();
        inspectionRegistry = new InspectionRegistry();
        paymentAuthorization = new PaymentAuthorization();
        controller = new Controller(garage, printer, cashRegister, inspectionRegistry, paymentAuthorization);
        InspectionItem item1 = new InspectionItem();
        InspectionItem item2 = new InspectionItem();
        InspectionItem item3 = new InspectionItem();

        inspectionItems = new ArrayList<>();
        inspectionItems.add(item1);
        inspectionItems.add(item2);
        inspectionItems.add(item3);

    }

    @After
    public void afterTest(){

        inspection = null;
        inspectionItems = null;
        garage = null;
        printer = null;
        cashRegister = null;
        inspectionRegistry = null;
        paymentAuthorization = null;
        controller = null;

    }

    @Test
    public void openDoor() throws Exception {
        assertFalse(controller.openDoor().equalsIgnoreCase("This will pass"));
        assertTrue(controller.openDoor().equalsIgnoreCase("Garage is opening the door"));


    }

    @Test
    public void nextCustomer() throws Exception {
        assertFalse(controller.nextCustomer().equalsIgnoreCase("This is wrong output"));
        assertTrue(controller.nextCustomer().equalsIgnoreCase("Garage is showing next queue number and letting the customer in"));

    }

    @Test
    public void closeTheDoor() throws Exception {
        assertFalse(controller.closeTheDoor().equalsIgnoreCase("This is wrong output"));
        assertTrue(controller.closeTheDoor().equalsIgnoreCase("Garage is closing the door"));

    }

    @Test
    public void checkRegNrAndCost() throws Exception {


        int regNr = 1234;

        inspection = new Inspection(regNr, inspectionItems, inspectionRegistry);
        List<InspectionItem> emptylist = null;

        Inspection inspectionWithEmptyList = new Inspection(regNr, emptylist, inspectionRegistry);
        controller.inspection = inspectionWithEmptyList;
        assertEquals(3000, controller.checkRegNrAndCost(regNr), 0);


    }

    @Test
    public void checkWhatToInspect() throws Exception {

        int regNr = 1234;
        inspection = new Inspection(regNr, inspectionItems, inspectionRegistry);

        InspectionItem item1 = new InspectionItem();
        InspectionItem item2 = new InspectionItem();
        InspectionItem item3 = new InspectionItem();

        List<InspectionItem> inspectionItemslocal = new ArrayList<>();
        List<InspectionItem> copyOfInspectionItems = inspectionItems;
        inspectionItemslocal.add(item1);
        inspectionItemslocal.add(item2);
        inspectionItemslocal.add(item3);


        assertFalse(inspectionItems.equals(inspectionItemslocal));
        assertTrue(inspectionItems.equals(copyOfInspectionItems));

    }


    @Test
    public void payByCash() throws Exception {
        double cost = 3000;
        double wrongCost = 1000;
        String receipt = printer.printCashReceipt(cost);
        assertTrue( receipt.equalsIgnoreCase("Payment " + cost));
        assertFalse(receipt.equalsIgnoreCase("Payment " + wrongCost));
    }

    @Test
    public void payByCard() throws Exception {
        int pin = 2222;
        double cost = 3000;
        CreditCard creditCard = new CreditCard(pin, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);

        assertEquals(paymentAuthorization.authorizePaymentCreditCard(creditCard, cost), true);

    }


}