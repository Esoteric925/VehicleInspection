package integration;

import model.InspectionItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Amir on 2017-04-30.
 */
public class InspectionRegistry {

    HashMap<Integer,List<InspectionItem>> inspectionDB = new HashMap<>();
    List<InspectionItem> audi = new ArrayList<InspectionItem>();
    List<InspectionItem> bmw = new ArrayList<InspectionItem>();



    public List<InspectionItem> getInspection(int regNr){

        return null;
    }

    public void storeItemResult(InspectionItem inspectedPart){

    }

    public void initRegistry(){


        InspectionItem wheelsAudi = new InspectionItem();
        wheelsAudi.setItem("wheels");
        InspectionItem stickAudi = new InspectionItem();
        stickAudi.setItem("stick");
        InspectionItem windowsAudi = new InspectionItem();
        windowsAudi.setItem("windows");
        audi.add(wheelsAudi);
        audi.add(stickAudi);
        audi.add(windowsAudi);

        InspectionItem engineBMW = new InspectionItem();
        wheelsAudi.setItem("engine");
        InspectionItem seatBMW = new InspectionItem();
        stickAudi.setItem("seat");
        bmw.add(engineBMW);
        bmw.add(seatBMW);

        inspectionDB.put(1234, audi);
        inspectionDB.put(5678, bmw);


    }


}
