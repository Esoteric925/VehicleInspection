package controller;

import integration.Garage;
import integration.InspectionRegistry;
import integration.PaymentAuthorization;
import integration.Printer;
import model.CreditCard;
import model.Inspection;
import model.InspectionItem;

/**
 * Created by Amir on 2017-04-30.
 */
public class Controller {

    Garage garage;
    Printer printer;
    Inspection inspection;
    InspectionRegistry inspectionRegistry;
    PaymentAuthorization paymentAuthorization;

    public Controller(Garage garage, Printer printer, Inspection inspection,
                      InspectionRegistry inspectionRegistry, PaymentAuthorization paymentAuthorization){

        this.garage = garage;
        this.printer = printer;
        this.inspection = inspection;
        this.inspectionRegistry = inspectionRegistry;
        this.paymentAuthorization = paymentAuthorization;


    }

    public void initiateInspection(){

    }

    public void closeTheDoor(){

    }

    public void checkRegNr(int regNr){

    }

    public InspectionItem checkWhatToInspect(){

        return null;
    }

    public void StoreItemResult(InspectionItem inspectionItem){

    }

    public void payByCash(double amount){

    }

    public boolean payByCard(CreditCard creditCard){
        return true;
    }


}
