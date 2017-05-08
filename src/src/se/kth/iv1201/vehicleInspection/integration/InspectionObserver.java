package se.kth.iv1201.vehicleInspection.integration;

import se.kth.iv1201.vehicleInspection.model.Inspection;
import se.kth.iv1201.vehicleInspection.model.InspectionItem;

/**
 * Created by araxi on 2017-05-06.
 */
public interface InspectionObserver {



    /**
     *
     * @param status of the whole inspection
     */

    void failedWholeInspection(boolean status);

    /**
     * Whole inspection if it has passed
     */
    void passedWholeInspection();
}
