package se.kth.iv1201.vehicleInspection.view;

import se.kth.iv1201.vehicleInspection.integration.InspectionObserver;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

/**
 * Represents the inspection stats view of a vehicle inspection.
 */
public class InspectionStatsView implements InspectionObserver {
    private int passedInspections;
    private int failedInspections;

    public InspectionStatsView(){
        passedInspections = 0;
        failedInspections = 0;
    }
    /**
     *
     * @param status of the whole inspection made
     *               Prints out the message of the whole inspection if it has failed
     */
    @Override
    public void failedWholeInspection(boolean status) {
        System.out.println("### We have now failed an inspection ###");
        failedInspections++;
        System.out.println("Failed inspections are: " + failedInspections);
        System.out.println("##############################");
    }

    /**
     * Message of the whole inspection
     */

    @Override
    public void passedWholeInspection() {

        System.out.println("### We have now passed an inspection ###");
        passedInspections++;
        System.out.println("Passed inspections are: " + passedInspections);
        System.out.println("##############################");

    }


}
