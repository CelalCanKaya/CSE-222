package com.company.Q2Folder;

/**
 * Part2 İçin main test
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("-------------------- \n PART 2 - TEST  \n--------------------\n");


        Part2<Integer> obj2 = new Part2<>(8);
        obj2.add(5);
        obj2.printTable(obj2.getArr());
        obj2.add(3);
        obj2.printTable(obj2.getArr());
        obj2.add(2);
        obj2.printTable(obj2.getArr());
        obj2.add(1);
        obj2.printTable(obj2.getArr());
        obj2.add(13);
        obj2.printTable(obj2.getArr());
        obj2.add(9);
        obj2.printTable(obj2.getArr());
        obj2.add(17);
        obj2.printTable(obj2.getArr());
        obj2.add(25);
        obj2.printTable(obj2.getArr());
        obj2.add(33);
        obj2.printTable(obj2.getArr());
        obj2.add(49);
        obj2.printTable(obj2.getArr());
        obj2.add(96);
        obj2.printTable(obj2.getArr());
        obj2.add(98);
        obj2.printTable(obj2.getArr());
        obj2.add(97);
        obj2.printTable(obj2.getArr());
        obj2.remove(4);
        obj2.printTable(obj2.getArr());
        obj2.remove(6);
        obj2.printTable(obj2.getArr());
        obj2.remove(17);
        obj2.printTable(obj2.getArr());
        obj2.remove(49);
        obj2.printTable(obj2.getArr());
        obj2.contains(2);
        obj2.printTable(obj2.getArr());

        System.out.print("\n\n-------------------- \n PART 2 - TEST 2\n--------------------\n");


        Part2<Integer> obj3 = new Part2<>(5);
        obj3.add(5);
        obj3.printTable(obj3.getArr());
        obj3.add(3);
        obj3.printTable(obj3.getArr());
        obj3.add(11);
        obj3.printTable(obj3.getArr());
        obj3.add(0);
        obj3.printTable(obj3.getArr());
        obj3.remove(0);
        obj3.printTable(obj3.getArr());
        obj3.add(12);
        obj3.printTable(obj3.getArr());
        obj3.add(16);
        obj3.printTable(obj3.getArr());
        obj3.add(25);
        obj3.printTable(obj3.getArr());
        obj3.add(33);
        obj3.printTable(obj3.getArr());
        obj3.remove(49);
        obj3.printTable(obj3.getArr());
        obj3.remove(33);
        obj3.printTable(obj3.getArr());
        obj3.add(123);
        obj3.printTable(obj3.getArr());
        obj3.add(44);
        obj3.printTable(obj3.getArr());
        obj3.contains(16);
        obj3.printTable(obj3.getArr());
        obj3.contains(11);
        obj3.printTable(obj3.getArr());
        obj3.add(16);
        obj3.printTable(obj3.getArr());
        obj3.add(17);
        obj3.printTable(obj3.getArr());
    }
}
