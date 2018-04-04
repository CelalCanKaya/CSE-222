package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * LinkedList objesi kullanarak, o linkedListteki elemanları belli ölçütlere göre ayırıp gösteren class
 */
public class Part1 {

    /**
     * Tüm course'ları dosyadan ekleyip yazdıgım linkedlist
     */
    private LinkedList<Courses> linkedlist;

    /**
     * Default constructor
     */
    public Part1() {
        this.linkedlist = new LinkedList<Courses>();
    }

    /**
     * Course'ları dosyadan okuyup linkedlist'e ekleyen metod
     * @throws FileNotFoundException Dosya bulunmazsa fırlatılan exception
     */
    public void ConstructLinkedList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("courses.csv"));
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
            linkedlist.add(temp);
        }
    }

    /**
     * Verilen ders koduna göre linkedList'teki elemanları filtreleyip sadece o elemanları başka bir linkedlist'te return ediyorum.
     * @param code Verilen Ders Kodu
     * @return Filtrelenmiş linked list
     */
    public LinkedList<Courses> getByCode(String code){
        LinkedList<Courses> resList = new LinkedList<Courses>();
        Iterator<Courses> itr = linkedlist.iterator();
        while(itr.hasNext()){
            resList.add(itr.next());
            if(!(resList.getLast().getCourseCode().equals(code))){
                resList.removeLast();
            }
        }
        return resList;
    }

    /**
     * Verilen semester'a göre linkedList'teki elemanları filtreleyip sadece o elemanları başka bir linkedlist'te return ediyorum.
     * @param semester Verilen Semester
     * @return Filtrelenmiş linked list
     */
    public LinkedList<Courses> listSemesterCourses(int semester) throws IndexOutOfBoundsException{
        LinkedList<Courses> resList = new LinkedList<Courses>();
        Iterator<Courses> itr = linkedlist.iterator();
        while(itr.hasNext()){
            resList.add(itr.next());
            if(!(resList.getLast().getSemester()==semester)){
                resList.removeLast();
            }
        }
        return resList;
    }

    /**
     * Belli bir indexten, belli bir indexe kadar olan elemanları gösterdigim fonksiyon
     * @param start_index Başlangıc indexi
     * @param last_index Bitiş indexi
     * @return Filtrelenmiş linked list
     */
    public LinkedList<Courses> getByRange(int start_index, int last_index) throws IndexOutOfBoundsException{
        LinkedList<Courses> resList = new LinkedList<Courses>();
        Iterator<Courses> itr = linkedlist.iterator();
        for(int i = start_index; i<last_index; i++) {
            resList.add(linkedlist.get(i));
        }

        return resList;
    }
}
