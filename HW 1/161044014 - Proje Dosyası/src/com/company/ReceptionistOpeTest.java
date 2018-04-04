package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ReceptionistOpeTest {

    @Test
    public void checkInTest() throws IOException {
        MainMenu m = new MainMenu();
        ReceptionistOpe receptionist = new ReceptionistOpe();
        Room[] rooms = new Room[15];
        for(int i=0; i<15; i++){
            rooms[i] = new Room();
        }
        m.fillRoomsArr(rooms);
        m.updateRecords(rooms);
        Assert.assertEquals(receptionist.CheckInTest("880", "1", rooms),true);
        Assert.assertEquals(receptionist.CheckInTest("880", "2", rooms),false);
    }

    @Test
    public void checkOutTest() throws IOException {
        MainMenu m = new MainMenu();
        ReceptionistOpe receptionist = new ReceptionistOpe();
        Room[] rooms = new Room[15];
        for(int i=0; i<15; i++){
            rooms[i] = new Room();
        }
        m.fillRoomsArr(rooms);
        m.updateRecords(rooms);
        Assert.assertEquals(receptionist.CheckOutTest("880", "1", rooms),false);
        Assert.assertEquals(receptionist.CheckOutTest("880", "2", rooms),true);

    }
}