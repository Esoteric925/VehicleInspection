package se.kth.iv1201.vehicleInspection.model;

/**
 * Thrown when there is no inspection for that licence number
 */
public class IllegalLicenceNumberException extends Exception {
    public IllegalLicenceNumberException(int regNr) {
         super("Unable to find an inspection with that licence number " + regNr);
        }

}
