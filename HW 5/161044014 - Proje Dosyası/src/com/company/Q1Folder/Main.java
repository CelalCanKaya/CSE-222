package com.company.Q1Folder;


public class Main {

    /**
     * Part 1 için main test
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("-------------------- \n PART 1 - TEST 1  \n--------------------\n\n");
        Part1<String,Integer> obj = new Part1<>();
        obj.put("CELAL", 8);
        obj.printHash();
        obj.put("CAN", 12);
        obj.printHash();
        obj.remove("CAN");
        obj.printHash();
        obj.put("KAYA", 7);
        obj.printHash();
        obj.put("GTU", 1);
        obj.printHash();
        obj.put("GTU", 3);
        obj.printHash();
        obj.get("GTU");
        obj.printHash();
        obj.get("KAYA");
        obj.printHash();
        obj.get("CELAL");
        obj.printHash();
        obj.get("CAN");
        obj.printHash();
        obj.put("ODEV", 2);
        obj.printHash();
        obj.remove("ODEV");
        obj.printHash();
        obj.put("MERHABA", 4);
        obj.printHash();
        obj.get("MERHABA");
        obj.printHash();
        obj.put("TESEKKUR", 0);
        obj.printHash();

        System.out.print("\n\n-------------------- \n PART 1 - TEST 2  \n--------------------\n\n");

        Part1<Integer,Integer> obj2 = new Part1<>(3);
        obj2.put(2, 4);
        obj2.printHash();
        obj2.remove(2);
        obj2.printHash();
        obj2.put(4, 5);
        obj2.printHash();
        obj2.get(2);
        obj2.printHash();
        obj2.put(6, 7);
        obj2.printHash();
        obj2.put(12, 2);
        obj2.printHash();
        obj2.get(6);
        obj2.printHash();
        obj2.get(12);
        obj2.printHash();
        obj2.put(8, 8);
        obj2.printHash();
        obj2.put(5, 1);
        obj2.printHash();

    }
}
