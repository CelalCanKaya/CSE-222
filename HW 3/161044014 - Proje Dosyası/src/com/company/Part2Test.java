package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part2Test {

    @Test
    void disable() {
        Part2<Integer> a = new Part2();
        a.add(5);
        Assertions.assertEquals(a.disable(5),true);
        Assertions.assertEquals(a.disable(6),false);


    }

    @Test
    void enable() {
        Part2<Integer> a = new Part2();
        a.add(5);
        a.disable(5);
        Assertions.assertEquals(a.enable(5),true);
        Assertions.assertEquals(a.disable(6),false);

    }
}