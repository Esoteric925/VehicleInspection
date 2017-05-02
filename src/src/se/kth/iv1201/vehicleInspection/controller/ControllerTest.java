package se.kth.iv1201.vehicleInspection.controller;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1201.vehicleInspection.integration.Garage;
import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1201.vehicleInspection.integration.PaymentAuthorization;
import se.kth.iv1201.vehicleInspection.integration.Printer;
import se.kth.iv1201.vehicleInspection.model.CashRegister;

import static org.junit.Assert.*;

/**
 * Created by araxi on 2017-05-02.
 */
public class ControllerTest {
    Garage garage;
    Printer printer;
    CashRegister cashRegister;
    InspectionRegistry inspectionRegistry;
    PaymentAuthorization paymentAuthorization;
    Controller controller;
    @Before
    public void setUp() throws Exception {

        garage = new Garage();
        printer = new Printer();
        cashRegister = cashRegister;
        inspectionRegistry = inspectionRegistry;
        paymentAuthorization = paymentAuthorization;
        controller = new Controller(garage, printer, cashRegister, inspectionRegistry, paymentAuthorization);

    }

    @Test
    public void createInspection() throws Exception {

    }

    @Test
    public void getInspectionList() throws Exception {
    }

    @Test
    public void openDoor() throws Exception {

        assertFalse(controller.closeTheDoor().equalsIgnoreCase("Garage is opening the door"));
    }

    @Test
    public void nextCustomer() throws Exception {
    }

    @Test
    public void closeTheDoor() throws Exception {
    }

    @Test
    public void checkRegNr() throws Exception {
    }

    @Test
    public void checkWhatToInspect() throws Exception {
    }

    @Test
    public void storeItemResult() throws Exception {
    }

    @Test
    public void payByCash() throws Exception {
    }

    @Test
    public void payByCard() throws Exception {
    }

    @Test
    public void printInspectionResult() throws Exception {
    }

}