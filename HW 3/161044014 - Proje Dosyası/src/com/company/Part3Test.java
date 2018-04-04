package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part3Test {

    @Test
    void size() {
        Part3 a = new Part3();

        Assertions.assertEquals(a.size(),0);

        Courses temp = new Courses();
        temp.setSemester(4);
        temp.setCourseCode("CSE 222");
        temp.setCourseTitle("Data Structures And Algorithms");
        temp.setEctsCredit(9);
        temp.setGtuCredit(5);
        temp.setHtl("4+2+0");
        a.add(temp);

        Assertions.assertEquals(a.size(),1);


    }

    @Test
    void add() {
        Part3 a = new Part3();

        Courses temp = new Courses();
        temp.setSemester(4);
        temp.setCourseCode("CSE 222");
        temp.setCourseTitle("Data Structures And Algorithms");
        temp.setEctsCredit(9);
        temp.setGtuCredit(5);
        temp.setHtl("4+2+0");
        Assertions.assertEquals(a.add(-1,temp),false);
        Assertions.assertEquals(a.add(0,temp),true);

    }

    @Test
    void remove() {
        Part3 a = new Part3();

        Courses temp = new Courses();
        temp.setSemester(4);
        temp.setCourseCode("CSE 222");
        temp.setCourseTitle("Data Structures And Algorithms");
        temp.setEctsCredit(9);
        temp.setGtuCredit(5);
        temp.setHtl("4+2+0");
        a.add(temp);

        Assertions.assertEquals(a.remove(1),false);
        Assertions.assertEquals(a.remove(0),true);
    }
}