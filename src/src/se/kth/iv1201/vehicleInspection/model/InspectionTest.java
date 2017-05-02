package se.kth.iv1201.vehicleInspection.model;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1201.vehicleInspection.integration.InspectionRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by araxi on 2017-05-01.
 */
public class InspectionTest {
    InspectionItem item1;
    InspectionItem item2;
    InspectionItem item3;

    List<InspectionItem> inspectionItems;
    Inspection inspection;
    InspectionRegistry inspectionRegistry;
    @Before
    public void setUp() throws Exception {
        item1 = new InspectionItem();
        item2 = new InspectionItem();
        item3 = new InspectionItem();

        inspectionItems = new ArrayList<>();
        inspectionItems.add(item1);
        inspectionItems.add(item2);
        inspectionItems.add(item3);

        int regNr = 1234;
        inspectionRegistry = new InspectionRegistry();
        inspection = new Inspection(regNr, inspectionItems, inspectionRegistry);

    }

    @Test
    public void calculateCost() throws Exception {
        double cost = 3000;
        assertEquals(cost, inspection.calculateCost(inspectionItems), 0);
    }


    @Test
    public void storeItemResult() throws Exception {



    }

}