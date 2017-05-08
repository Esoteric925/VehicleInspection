package se.kth.iv1201.vehicleInspection.log;

import se.kth.iv1201.vehicleInspection.model.IllegalLicenceNumberException;

import java.io.*;
import java.util.Date;

/**
 * Created by araxi on 2017-05-08.
 */
public class Logger {




    public void writeToLog(IllegalLicenceNumberException e)  {
        try{
            PrintWriter writer = new PrintWriter("LOG.txt", "UTF-8");
            writer.println("Time: " + new Date() + " Exception: " + e);
            //writer.println();
            writer.close();

        } catch (IOException ex) {
            // do something
        }



    }
}
