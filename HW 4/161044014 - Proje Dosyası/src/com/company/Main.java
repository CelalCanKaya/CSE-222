package com.company;

import java.util.ArrayList;

public class Main {

    /**
     * Ana Senaryolarım. Gerekli Aciklamalari Ekrana Bastirdim.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("PART 1 - 1. TEST AGACI  ( LEVEL ORDER'A GORE SIRALIYOR. EN SONDA POST ORDER'I TEK BASINA ROOT ELEMANI ICIN CAGIRDIM. BÖYLECE POST ORDER'INDA DOGRU CALISTIGINI GOREBILIRSINIZ.)");
        System.out.println("------------------------------------------------------------------------------------");


        Part1<Integer> a = new Part1();
        System.out.print("Parent:Root Eklenen Child:1 - LevelOrder: ");
        a.add(1,1);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:1 Eklenen Child:2 - LevelOrder: ");
        a.add(1,2);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:1 Eklenen Child:4 - LevelOrder: ");
        a.add(1,4);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:1 Eklenen Child:7 - LevelOrder: ");
        a.add(1,7);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:2 Eklenen Child:3 - LevelOrder: ");
        a.add(2,3);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:2 Eklenen Child:6 - LevelOrder: ");
        a.add(2,6);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:3 Eklenen Child:5 - LevelOrder: ");
        a.add(3,5);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:7 Eklenen Child:8 - LevelOrder: ");
        a.add(7,8);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:7 Eklenen Child:9 - LevelOrder: ");
        a.add(7,9);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:10 - LevelOrder: ");
        a.add(8,10);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:11 - LevelOrder: ");
        a.add(8,11);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:12 - LevelOrder: ");
        a.add(8,12);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:10 Eklenen Child:13 - LevelOrder: ");
        a.add(10,13);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n Parent:13 Eklenen Child:20 - LevelOrder: ");
        a.add(13,20);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        a.toString();
        System.out.print("\n\n POST ORDER TEST : ");
        a.postOrderSearch(a.root, 1);

        System.out.println("\n\n------------------------------------------------------------------------------------");
        System.out.println("PART 1 - 1. TEST AGACI  ( LEVEL ORDER'A GORE SIRALIYOR. EN SONDA POST ORDER'I TEK BASINA ROOT ELEMANI ICIN CAGIRDIM. BÖYLECE POST ORDER'INDA DOGRU CALISTIGINI GOREBILIRSINIZ.)");
        System.out.println("------------------------------------------------------------------------------------");

        Part1<Integer> b = new Part1();
        System.out.print("Parent:Root Eklenen Child:8 - LevelOrder: ");
        b.add(1,8);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:3 - LevelOrder: ");
        b.add(8,3);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:4 - LevelOrder: ");
        b.add(8,4);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:3 Eklenen Child:2 - LevelOrder: ");
        b.add(3,2);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:2 Eklenen Child:5 - LevelOrder: ");
        b.add(2,5);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:2 Eklenen Child:7 - LevelOrder: ");
        b.add(2,7);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:8 Eklenen Child:9 - LevelOrder: ");
        b.add(8,9);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:9 Eklenen Child:1 - LevelOrder: ");
        b.add(9,1);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:4 Eklenen Child:10 - LevelOrder: ");
        b.add(4,10);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:7 Eklenen Child:6 - LevelOrder: ");
        b.add(7,6);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:7 Eklenen Child:11 - LevelOrder: ");
        b.add(7,11);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:6 Eklenen Child:5 - LevelOrder: ");
        b.add(6,5);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:5 Eklenen Child:13 - LevelOrder: ");
        b.add(5,13);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n\n Parent:13 Eklenen Child:14 - LevelOrder: ");
        b.add(13,14);
        System.out.println("\n\nTree'nin Son Durumu; \n");
        b.toString();
        System.out.print("\n POST ORDER TEST : ");
        b.postOrderSearch(b.root, 8);

        System.out.println("\n\n------------------------------------------------------------------------------------");
        System.out.println("PART 2 - SADECE ADD METODU IMPLEMENT EDILDI.");
        System.out.println("------------------------------------------------------------------------------------");


        Part2<Integer> c = new Part2();
        c.add(new Integer[]{3,2,3});
        c.add(new Integer[]{4,5,8});
        c.add(new Integer[]{2,6,9});
        c.add(new Integer[]{7,1,5});

        // toString metodunu override etmedigim icin suan icin böyle erisebiliyorum
        System.out.print(c.rootNode.data[0]);
        System.out.print(c.rootNode.data[1]);
        System.out.println(c.rootNode.data[2]);
        System.out.print(c.rootNode.left.data[0]);
        System.out.print(c.rootNode.left.data[1]);
        System.out.println(c.rootNode.left.data[2]);
        System.out.print(c.rootNode.right.data[0]);
        System.out.print(c.rootNode.right.data[1]);
        System.out.println(c.rootNode.right.data[2]);
        System.out.print(c.rootNode.right.left.data[0]);
        System.out.print(c.rootNode.right.left.data[1]);
        System.out.println(c.rootNode.right.left.data[2]);



    }
}
