package se.kth.iv1201.vehicleInspection.integration;

/**
 * Thrown when there is no inspection for that licence number
 */
public class IllegalLicenceNumberException extends Exception {

    /**
     *
     * @param regNr the registration number for the vehicle
     */
    public IllegalLicenceNumberException(int regNr) {
         super("Unable to find an inspection with that licence number " + regNr);
        }

}
