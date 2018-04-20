package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Part1Test {

    @Test
    public void add() {
        Part1<Integer> a = new Part1();
        a.add(1,1);
        Assertions.assertEquals(a.add(1,2),true);
        Assertions.assertEquals(a.add(5,4),false);

    }

    @Test
    public void levelOrderSearch() {
        Part1<Integer> a = new Part1();
        a.add(1,1);
        a.add(1,2);
        a.add(1,3);
        a.add(2,4);
        a.add(2,5);
        a.add(4,6);

        Assertions.assertEquals(a.levelOrderSearch(a.root,2),a.root.left);
        Assertions.assertEquals(a.levelOrderSearch(a.root,16),null);


    }

    @Test
    public void postOrderSearch() {
        Part1<Integer> a = new Part1();
        a.add(1,1);
        a.add(1,2);
        a.add(1,3);
        a.add(2,4);
        a.add(2,5);
        a.add(4,6);

        Assertions.assertEquals(a.postOrderSearch(a.root,2),a.root.left);
        Assertions.assertEquals(a.postOrderSearch(a.root,16),null);


    }
}