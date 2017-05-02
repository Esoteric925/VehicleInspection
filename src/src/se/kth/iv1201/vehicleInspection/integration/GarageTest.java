package se.kth.iv1201.vehicleInspection.integration;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * Created by araxi on 2017-05-01.
 */
public class GarageTest {
    Garage garage;
    @Before
    public void setUp() throws Exception {
            garage = new Garage();
    }

    @Test
    public void closeDoor() throws Exception {
        Garage garage = new Garage();
        assertEquals(this.garage.closeDoor(), garage.closeDoor());
    }

    @Test
    public void openDoor() throws Exception {
        Garage garage = new Garage();
        assertEquals(this.garage.openDoor(), garage.openDoor());
    }

    @Test
    public void nextCustomer() throws Exception {
        Garage garage = new Garage();
        assertEquals(this.garage.nextCustomer(), garage.nextCustomer());
    }

}