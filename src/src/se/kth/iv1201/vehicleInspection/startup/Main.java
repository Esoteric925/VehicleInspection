package se.kth.iv1201.vehicleInspection.startup;

import se.kth.iv1201.vehicleInspection.controller.Controller;
import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1201.vehicleInspection.integration.PaymentAuthorization;
import se.kth.iv1201.vehicleInspection.model.CashRegister;
import se.kth.iv1201.vehicleInspection.model.Inspection;
import se.kth.iv1201.vehicleInspection.view.View;
import se.kth.iv1201.vehicleInspection.integration.Garage;
import se.kth.iv1201.vehicleInspection.integration.Printer;

import java.util.Scanner;

/**
 * Represents the start up for the inspection
 */
public class Main {

    /**
     * Initiates the start up for the inspection
     * @param args
     */
    public static void main(String[] args) {

        InspectionRegistry inspectionRegistry = new InspectionRegistry();
        Printer printer = new Printer();
        Garage garage = new Garage();
        CashRegister cashRegister = new CashRegister();
        PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
        inspectionRegistry.initRegistry();
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a registration number to begin inspection [NNNN]: ");
        int regNr = reader.nextInt();


        Inspection inspection = new Inspection(regNr, inspectionRegistry.getInspection(regNr), inspectionRegistry);
        Controller controller = new Controller(garage, printer, inspection, cashRegister, inspectionRegistry, paymentAuthorization);
        View view = new View(controller, regNr);
        view.start();
    }
}
