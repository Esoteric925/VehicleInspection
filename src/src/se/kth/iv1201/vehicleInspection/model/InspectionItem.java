package se.kth.iv1201.vehicleInspection.model;

/**
 *  Represents an item that is part of the inspection for a specific vehicle
 */
public class InspectionItem {

    boolean status;
    String itemName;

    /**
     *
     * @return The status for the specified InspectionItem
     */
    public boolean getStatus(){
        return status;
    }

    /**
     *
     * @param status Sets the status for the specified InspectionItem
     */
    public void setStatus(boolean status){
        this.status = status;
    }

    /**
     *
     * @param itemName Sets the item name for specified InspectionItem
     */
    public void setItemName(String itemName){ this.itemName = itemName; }

    /**
     *
     * @return The name for the specified InspectionItem
     */
    public String getItemName(){
        return itemName;
    }
}
