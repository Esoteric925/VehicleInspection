package se.kth.iv1201.vehicleInspection.integration;

import se.kth.iv1201.vehicleInspection.model.Inspection;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

/**
 * Created by araxi on 2017-05-06.
 */
public interface InspectionObserver {

    void passedInspection(InspectionItem inspectionItem);

    void failedInspection(InspectionItem inspectionItem);
}
