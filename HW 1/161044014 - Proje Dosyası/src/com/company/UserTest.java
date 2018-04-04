package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UserTest {

    @Test
    public void bookRoomTest() throws IOException {
        MainMenu m = new MainMenu();
        User user = new User();
        Room[] rooms = new Room[15];
        for(int i=0; i<15; i++){
            rooms[i] = new Room();
        }
        m.fillRoomsArr(rooms);
        m.updateRecords(rooms);
        Assert.assertEquals(user.BookRoomTest("Emre", "Kaya", "880", "1", "4", rooms),true);
        Assert.assertEquals(user.BookRoomTest("Tarik", "Kilic", "1010", "2", "5", rooms),true);
        Assert.assertEquals(user.BookRoomTest("Fatih", "Sevim", "98765", "4", "5", rooms),true);
        Assert.assertEquals(user.BookRoomTest("Fatih", "Sevim", "98765", "5", "2", rooms),false);

    }

    @Test
    public void cancelBookTest() throws IOException {
        MainMenu m = new MainMenu();
        User user = new User();
        Room[] rooms = new Room[15];
        for(int i=0; i<15; i++){
            rooms[i] = new Room();
        }
        m.fillRoomsArr(rooms);
        m.updateRecords(rooms);
        Assert.assertEquals(user.CancelBookTest("880", "1", rooms),true);
        Assert.assertEquals(user.CancelBookTest("200", "2", rooms),false);
    }

}