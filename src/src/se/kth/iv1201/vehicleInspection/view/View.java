package se.kth.iv1201.vehicleInspection.view;

import se.kth.iv1201.vehicleInspection.controller.Controller;
import se.kth.iv1201.vehicleInspection.model.CreditCard;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.*;

/**
 * Represents the view for which the inspector is communicating with the program
 */
public class View {

    Controller controller;
    int regNr;

    /**
     * Creates a new instance, representing the specified view.
     * @param controller The controller for the inspection program
     * @param regNr the registration number for the vehicle to be inspected
     */
    public View(Controller controller, int regNr){
        this.controller = controller;
        this.regNr = regNr;
    }

    /**
     * Represents the TUI(Textbased UI) for the inspection program
     */
    public void start(){
        System.out.println("The inspector is initiating the inspection");
        controller.initiateInspection();
        controller.closeTheDoor();
        System.out.println();
        System.out.println("The inspector has entered the registration number " + regNr + ". Calculating cost....");
        double cost = controller.checkRegNr(regNr);
        System.out.println("The cost is: " + cost);
        System.out.println();

        Scanner reader = new Scanner(System.in);
        System.out.println("Do you want to pay with cash or creditcard? [cash/card]: ");
        boolean paymentStatus = true;
        while(paymentStatus == true) {
            String payment = reader.next();
            while (true) {
                if (payment.equalsIgnoreCase("cash")) {
                    System.out.println("You chose cash");
                    controller.payByCash(cost);
                    paymentStatus = false;
                    System.out.println();
                    break;
                } else if (payment.equalsIgnoreCase("card")) {
                    System.out.println("You chose credit card");
                    System.out.println("Enter your pin please: "); // FRÅGA OM OKEJ ATT HA SÅHÄR
                    int pin = reader.nextInt();
                    CreditCard creditCard = new CreditCard(pin, "1234 5678 9101 1213", "Anna Panna", new Date(), 322);
                    boolean success = controller.payByCard(creditCard, cost); //SKA VI KOLLA OM CREDITCARD FAILAR ELLER INTE?
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
            String result = reader.next(); // Scans the next token of the input as an int.
            if(result.equalsIgnoreCase("p")){
                controller.storeItemResult(item, true);
                System.out.println();
            }
            if(result.equalsIgnoreCase("f")){
                item.setStatus(false);
                controller.storeItemResult(item, false);
                System.out.println();
            }
        }
        controller.printInspectionResult(items);
        System.out.println("The inspector has ended the inspection");
    }
}
