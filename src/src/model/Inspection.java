package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amir on 2017-04-30.
 */
public class Inspection {

    int regNr;
    List<InspectionItem> inspectionItems = new ArrayList<>();

    public Inspection(int regNr, List<InspectionItem> inspectionItems){

        this.regNr = regNr;
        this.inspectionItems = inspectionItems;

    }

    public double calculateCost(List<InspectionItem> inspectionItems){
        return 0;
    }

    public InspectionItem inspectPart(InspectionItem item){
        return null;
    }

    public void storeItemResult(InspectionItem inspectedItem){

    }


}
