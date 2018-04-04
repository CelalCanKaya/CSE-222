package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    /**
     * PART 1 - 2 ve 3 ' ü sırayla test ettim.
     * @param args
     * @throws FileNotFoundException Courses.csv veya Courses2.csv'yi bulamazsa throwlanan exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("PART 1 - TEST\n\n\n\n");
        LinkedList<Courses> linkedlist;
        Part1 obj = new Part1();
        obj.ConstructLinkedList();
        System.out.println("XXX XXX Koduna Sahip Dersleri Listeledim.\n\n");
        linkedlist = obj.getByCode("XXX XXX");
        System.out.print(linkedlist + "\n\n");
        System.out.println("CSE 222 Koduna Sahip Dersleri Listeledim.\n\n");
        linkedlist = obj.getByCode("CSE 222");
        System.out.print(linkedlist + "\n\n");
        try {
            System.out.println("2. Semester Derslerini Listeledim.\n\n");
            linkedlist = obj.listSemesterCourses(2);
            System.out.print(linkedlist + "\n\n");
            System.out.println("4. Semester Derslerini Listeledim.\n\n");
            linkedlist = obj.listSemesterCourses(4);
            System.out.print(linkedlist + "\n\n");
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Index, Sizedan Buyuk!");
        }
        try {
            System.out.println("1. Indexten, 6. Indexe Kadar Olan Dersleri Listeledim.\n\n");
            linkedlist = obj.getByRange(1, 6);
            System.out.print(linkedlist + "\n\n");
            System.out.println("14. Indexten, 20. Indexe Kadar Olan Dersleri Listeledim.\n\n");
            linkedlist = obj.getByRange(14, 20);
            System.out.print(linkedlist + "\n\n");
        }
        catch(IndexOutOfBoundsException exception){
            System.out.println("Index, Sizedan Buyuk!");
        }

        linkedlist = obj.getByRange(0, 15); // PART2'YI TEST ETMEK ICIN ILK PARTTA OLUSTURUDUGUM LINKED LISTTEKI ILK 15 ELEMANI ALDIM.


        System.out.print("\n\n\n\n");
        System.out.print("PART 2 - TEST\n\n\n\n");

        Part2<Courses> b = new Part2();

        System.out.println("Ilk parttaki linked listemin 2. indexini listeye ekledim.");
        b.add(linkedlist.get(2));
        System.out.println("Ilk parttaki linked listemin 4. indexini listeye ekledim.");
        b.add(linkedlist.get(4));
        System.out.println("Ilk parttaki linked listemin 5. indexini listeye ekledim.");
        b.add(linkedlist.get(5));
        System.out.println("Ilk parttaki linked listemin 0. indexini listeye ekledim.");
        b.add(linkedlist.get(0));
        System.out.println("Ilk parttaki linked listemin 14. indexini listeye ekledim.");
        b.add(linkedlist.get(14));
        System.out.println("Ilk parttaki linked listemin 6. indexini listeye ekledim.");
        b.add(linkedlist.get(6));
        System.out.println("\nEklemelerden sonra linked list: \n");
        System.out.print(b);
        System.out.println("\nLinked Listemin Size'ını Bastırdım.\n");
        System.out.print(b.size());
        System.out.println("\n\nLinked Listemin 2. Indexini Disable Ettim.");
        b.disable(b.get(2));
        System.out.println("Linked Listemin Size'ı 5'e düştü.4. Indexini Disable Ettim.Bu nedenle listemin ilk halindeki son eleman disable oldu.");
        b.disable(b.get(4));
        System.out.println("\nLinked Listemin Size'ını Bastırdım.\n");
        System.out.print(b.size());
        System.out.println("\n\nDisabled Listemi Bastırdım.\n\n");
        b.showDisabled();
        System.out.println("\n\nIlk parttaki linked listemin 8. indexini, 2. indexe ekledim.\n");
        b.add(2,linkedlist.get(8));
        System.out.println("Daha önce 2. Indexten disable ettiğim elemanı enable ettim.\n");
        b.enable(b.getDisabled(0));
        System.out.println("\nLinked Listin Son Hali: \n");
        System.out.print(b);
        System.out.println("\n\nLinked Listimin 3. Indexini Başka Bir Elemanla Set Ettim.\n");
        b.set(3, linkedlist.get(10));
        System.out.println("\nLinked Listin Son Halini Override Ettiğim listIteratorle Bastırdım.Disable olan elemanı göstermedi.: \n");
        Iterator p2iterator = b.listIterator();
        while(p2iterator.hasNext()){
            System.out.print(p2iterator.next());
        }
        System.out.println("\n\nDisabled Listemi Bastırdım.\n\n");
        b.showDisabled();
        System.out.println("\n\nDisable elemanı enable ettim.");
        b.enable(b.getDisabled(0));
        System.out.println("Disabled Listemi Bastırdım.\n\n");
        b.showDisabled();
        System.out.println("\n\nLinked Listin Son Hali: \n");
        System.out.print(b);

        System.out.print("\n\n\n\n");
        System.out.print("PART 3 - TEST\n\n\n\n");

        Part3 x = new Part3();

        System.out.println("\n Next Ve NextInSemester'ın çalıştığını daha rahat görmek için courses.csv dosyasında bazı derslerin yerlerini değiştirdim ve courses2.csv dosyasına kaydettim.Burdaki karışık dersleri linked listeme ekledim. \n");
        Scanner scanner = new Scanner(new FileReader("courses2.csv"));
            scanner.useDelimiter(";");
            scanner.nextLine();
            while(scanner.hasNext()){
                Courses temp = new Courses();
                temp.setSemester(scanner.nextInt());
                temp.setCourseCode(scanner.next());
                temp.setCourseTitle(scanner.next());
                temp.setEctsCredit(scanner.nextInt());
                temp.setGtuCredit(scanner.nextInt());
                temp.setHtl(scanner.nextLine());
                x.add(temp);
            }
        System.out.println("\n Iteratorumu tanımladım. Iteratorle bir next elemanı gösterdim. \n");
        Part3.ListIterator iter = x.iterator();
        System.out.print(iter.next());
        System.out.println("\n 11 Kere NextInSemester'ı çağırdım böylece listemin circular oldugunu gösterdim. \n");
        for(int i=0; i<11; i++) {
            System.out.print(iter.nextInSemester());
        }
        System.out.println("\n next Methoduyla sıradaki elemanı gösterdim. \n");
        System.out.print(iter.next());
        System.out.println("\n nextInSemester Methoduyla sıradaki elemanı gösterdim. \n");
        System.out.print(iter.nextInSemester());
        System.out.println("\n next Methoduyla sıradaki elemanı gösterdim. \n");
        System.out.print(iter.next());
        System.out.println("\nLinked Listemin Size'ını Bastırdım.\n");
        System.out.print(x.size());
        System.out.println("\n\n12. Indexteki Elemanı Remove Ettim.\n");
        x.remove(12);
        System.out.println("\nLinked Listemin Size'ını Bastırdım.\n");
        System.out.print(x.size());
        System.out.println("\n\n16. Indexteki Elemanı Listenin Ekledim.\n");
        x.add(x.get(16));
        System.out.println("\n\n21. Indexteki Elemanı Listenin Ekledim.\n");
        x.add(x.get(21));
        System.out.println("\nLinked Listemin Size'ını Bastırdım.\n");
        System.out.print(x.size());
    }

}
