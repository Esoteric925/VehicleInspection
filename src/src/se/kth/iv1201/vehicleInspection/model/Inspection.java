package se.kth.iv1201.vehicleInspection.model;

import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents an inspection for a specific vehicle
 */
public class Inspection {

    int regNr;
    List<InspectionItem> inspectionItems = new ArrayList<>();
    InspectionRegistry inspectionRegistry;

    /**
     * Creates an instance of an inspection which holds the items to be inspected and
     * also the registry to be able to store item status
     *
     * @param regNr is the registration number for the vehicle that is being inspected
     * @param inspectionItems is all the items to be inspected in the specified inspection
     * @param inspectionRegistry is the registry for where the all inspection data are being stored
     */
    public Inspection(int regNr, List<InspectionItem> inspectionItems, InspectionRegistry inspectionRegistry){
        this.regNr = regNr;
        this.inspectionItems = inspectionItems;
        this.inspectionRegistry = inspectionRegistry;

    }

    /**
     * Calculates cost for a specified inspection
     * @param inspectionItems is all the items to be inspected in the specified inspection
     * @return the cost for the specified inspection
     */
    public double calculateCost(List<InspectionItem> inspectionItems){
        double cost = 0;
        Random r = new Random();

        for(int i = 0; i < inspectionItems.size(); i++){
            double d = 10.0 + r.nextDouble() * 100.0;
            cost +=  d;
        }
        return cost;
    }

    /**
     *
     * @return The list of all items to be inspected in the specified inspection
     */
    public List<InspectionItem> inspectParts(){
        return inspectionItems;
    }

    /**
     * Stores the result for an inspected item for a specified inspection
     * @param inspectedItem is a specific inspected item in the specified inspection
     * @param status is the status for the inspected item
     */
    public void storeItemResult(InspectionItem inspectedItem, boolean status){
        inspectionRegistry.storeItemResult(inspectedItem, status);
    }


}
