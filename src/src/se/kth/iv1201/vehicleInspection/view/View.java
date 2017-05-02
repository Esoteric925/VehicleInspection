package se.kth.iv1201.vehicleInspection.view;

import se.kth.iv1201.vehicleInspection.controller.Controller;
import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1201.vehicleInspection.model.CreditCard;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.*;

/**
 * Represents the view for which the inspector is communicating with the program
 */
public class View {

    Controller controller;
    InspectionRegistry inspectionRegistry;


    /**
     * Creates a new instance, representing the specified view.
     * @param controller The controller for the inspection program
     * @param inspectionRegistry the registry for where inspection data are being held
     */
    public View(Controller controller, InspectionRegistry inspectionRegistry){
        this.controller = controller;
        this.inspectionRegistry = inspectionRegistry;
    }

    /**
     * Represents the TUI(Textbased UI) for the inspection program
     */
    public void start(){

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a registration number to begin inspection [NNNN]: ");
        int regNr = reader.nextInt();
        controller.createInspection(regNr);

        System.out.println("The inspector is initiating the inspection");

        String openDoorMsg = controller.openDoor();
        String nextCustomerMsg = controller.nextCustomer();
        String doorClosingMsg = controller.closeTheDoor();
        System.out.println(openDoorMsg);
        System.out.println(nextCustomerMsg);
        System.out.println(doorClosingMsg);
        System.out.println();

        System.out.println("The inspector has entered the registration number " + regNr + ". Calculating cost....");
        double cost = controller.checkRegNrAndCost(regNr);
        System.out.println("The cost is: " + cost);
        System.out.println();

        System.out.println("Do you want to pay with cash or creditcard? [cash/card]: ");
        boolean paymentStatus = true;
        while(paymentStatus == true) {
            String payment = reader.next();
            while (true) {
                if (payment.equalsIgnoreCase("cash")) {
                    System.out.println("You chose cash");

                    String cashPaymentMsg = controller.payByCash(cost);
                    System.out.println("Payment by cash done in cash registry with cost " + cost);
                    System.out.println("Printing receipt for payment by cash...");
                    System.out.println(cashPaymentMsg);

                    paymentStatus = false;
                    System.out.println();
                    break;
                } else if (payment.equalsIgnoreCase("card")) {
                    System.out.println("You chose credit card");
                    System.out.println("Enter your pin please: ");
                    int pin = reader.nextInt();
                    CreditCard creditCard = new CreditCard(pin, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
                    boolean success = controller.payByCard(creditCard, cost);
                    paymentStatus = false;
                    System.out.println();
                    break;
                } else {
                    System.out.println("Please choose between [cash/card]");
                    break;
                }
            }
        }

        System.out.println("The inspector is checking what to inspect...");
        List<InspectionItem> items = controller.checkWhatToInspect();

        for(InspectionItem item : items){
            System.out.println("The inspector is inspecting item: " + item.getItemName());
            System.out.println("The inspector performed the inspection of the item: " + item.getItemName());

            System.out.println("Do inspector want to pass or fail item [p/f]");
            String result = reader.next();
            if(result.equalsIgnoreCase("p")){
                controller.storeItemResult(item, true);
                System.out.println("The inspector has stored the item result for item: " + item.getItemName() + " with status: " + true);
                System.out.println();
            }
            if(result.equalsIgnoreCase("f")){
                item.setStatus(false);
                controller.storeItemResult(item, false);
                System.out.println("The inspector has stored the item result for item: " + item.getItemName() + " with status: " + false);
                System.out.println();
            }
        }
        controller.printInspectionResult(items);
        System.out.println("The inspector has ended the inspection");
    }
}
