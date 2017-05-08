package se.kth.iv1201.vehicleInspection.log;

import se.kth.iv1201.vehicleInspection.integration.IllegalLicenceNumberException;

import java.io.*;
import java.util.Date;

/**
 * Logger is used to write to a logfile for the developer to check what exception has been caught
 * and why it was caught
 */
public class Logger {
    /**
     *
     * @param e is the illegal licence number that was caught
     */

    public void writeToLog(IllegalLicenceNumberException e)  {

        try(FileWriter fw = new FileWriter("LOG", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("Time: " + new Date() + " Exception: " + e);

        } catch (IOException ex) {
            //exception handling left as an exercise for the reader
        }



        /*try{
            PrintWriter writer = new PrintWriter("LOG.txt", "UTF-8");
            writer.println("Time: " + new Date() + " Exception: " + e);
            //writer.println();
            writer.close();

        } catch (IOException ex) {
            // do something
        }*/



    }
}
