package startup;

import controller.Controller;
import integration.Garage;
import integration.InspectionRegistry;
import integration.PaymentAuthorization;
import integration.Printer;
import model.Inspection;
import view.View;

/**
 * Created by Amir on 2017-04-30.
 */
public class Main {

    public static void main(String[] args) {



        InspectionRegistry inspectionRegistry = new InspectionRegistry();
        Inspection inspection = new Inspection(1234, inspectionRegistry.getInspection(1234));
        Printer printer = new Printer();

        Garage garage = new Garage();
        PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
        Controller controller = new Controller(garage, printer, inspection, inspectionRegistry, paymentAuthorization);
        inspectionRegistry.initRegistry();
        View view = new View(controller);

/*TODO Start with calling methods from the view to the controller*/


    }
}
