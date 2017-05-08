package se.kth.iv1201.vehicleInspection.startup;

import se.kth.iv1201.vehicleInspection.controller.Controller;
import se.kth.iv1201.vehicleInspection.integration.*;
import se.kth.iv1201.vehicleInspection.model.CashRegister;
import se.kth.iv1201.vehicleInspection.integration.IllegalLicenceNumberException;
import se.kth.iv1201.vehicleInspection.view.View;

/**
 * Represents the start up for the inspection
 */
public class Main {

    /**
     * Initiates the start up for the inspection
     * @param args
     */
    public static void main(String[] args) throws IllegalLicenceNumberException {

        InspectionRegistry inspectionRegistry = new InspectionRegistry();
        Printer printer = new Printer();
        Garage garage = new Garage();
        CashRegister cashRegister = new CashRegister();
        PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
        inspectionRegistry.initRegistry();
        Controller controller = new Controller(garage, printer, cashRegister, inspectionRegistry, paymentAuthorization);
        View view = new View(controller, inspectionRegistry);
        view.start();
    }
}
