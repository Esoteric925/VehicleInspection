package se.kth.iv1201.vehicleInspection.view;

import se.kth.iv1201.vehicleInspection.integration.InspectionObserver;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

/**
 * Created by araxi on 2017-05-06.
 */
public class InspectionStatsView implements InspectionObserver {
    private int passedInspections;
    private int failedInspections;

    public InspectionStatsView(){
        passedInspections = 0;
        failedInspections = 0;
    }

    @Override
    public void passedInspection(InspectionItem inspection) {
        printPassedInspectionState();

    }

    @Override
    public void failedInspection(InspectionItem inspection) {
        printFailedInspectionState();

    }

    private void printPassedInspectionState(){
        System.out.println("### We have now passed inspections ###");
        passedInspections++;
        System.out.println("Passed inspections are: " + passedInspections);
        System.out.println("##############################");
    }

    private void printFailedInspectionState(){
        System.out.println("### We have now failed inspections ###");
        failedInspections++;
        System.out.println("Failed inspections are: " + failedInspections);
        System.out.println("##############################");
    }
}
