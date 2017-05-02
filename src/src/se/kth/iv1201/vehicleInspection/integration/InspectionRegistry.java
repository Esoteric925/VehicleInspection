package se.kth.iv1201.vehicleInspection.integration;

import se.kth.iv1201.vehicleInspection.model.InspectionItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents an inspection registry/database to be able to store inspection data
 */
public class InspectionRegistry {

    HashMap<Integer,List<InspectionItem>> inspectionDB = new HashMap<>();
    List<InspectionItem> audi = new ArrayList<>();
    List<InspectionItem> bmw = new ArrayList<InspectionItem>();


    /**
     * Returns an inspection for a specific vehicle
     * @param regNr is the registration number for the vehicle that needs to be inspected
     * @return a list of all items that needs to be inspected by the inspector
     */
    public List<InspectionItem> getInspection(int regNr){

        if(inspectionDB.get(regNr) == null){
            System.out.println("No inspection for that vehicle");
            System.exit(1);
        }

        return new ArrayList<>(inspectionDB.get(regNr));
    }

    /**
     *
     * @param inspectedPart represents the item that has been inspected
     * @param status shows the status for that inspected item
     */
    public void storeItemResult(InspectionItem inspectedPart, boolean status){
        inspectedPart.setStatus(status);

        System.out.println("The inspector has stored the item result for item: " + inspectedPart.getItemName() + " with status: " + status);

      /*for(int i = 0; i <inspectionDB.get(regNr).size(); i++){
            System.out.println("item: " + inspectionDB.get(regNr).get(i).getItemName() + " status: " + inspectionDB.get(regNr).get(i).getStatus());
        }*/

    }

    /**
     * Initiates data that is stored in the inspection registry/database.
     * In this case some inspection items are being added in the registry for two cars, Audi and BMW
     */
    public void initRegistry(){


        InspectionItem wheelsAudi = new InspectionItem();
        wheelsAudi.setItemName("wheels");
        InspectionItem stickAudi = new InspectionItem();
        stickAudi.setItemName("stick");
        InspectionItem windowsAudi = new InspectionItem();
        windowsAudi.setItemName("windows");
        audi.add(wheelsAudi);
        audi.add(stickAudi);
        audi.add(windowsAudi);

        InspectionItem engineBMW = new InspectionItem();
        engineBMW.setItemName("engine");
        InspectionItem seatBMW = new InspectionItem();
        seatBMW.setItemName("seat");
        bmw.add(engineBMW);
        bmw.add(seatBMW);

        inspectionDB.put(1234, audi);
        inspectionDB.put(5678, bmw);

    }


}
