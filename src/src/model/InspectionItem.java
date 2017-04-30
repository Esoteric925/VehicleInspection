package model;

/**
 * Created by Amir on 2017-04-30.
 */
public class InspectionItem {


    boolean status;
    String item;

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }


    public void setItem(String item){
        this.item = item;
    }

    public String getItem(){
        return item;
    }
}
