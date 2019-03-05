package com.company.Q3Folder;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MergeSortDLL<Integer> m = new MergeSortDLL<>();
        LinkedList<Integer> list = new LinkedList<>();
        int array[] = {1000,4000};
        for(int i=0; i<2; i++) {
            for(int j=0; j<10; j++) {
                fillArr(array[i], list);
                long start = System.nanoTime();
                m.mergeSort(list);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }

        MergeSortDLL<Integer> m2 = new MergeSortDLL<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int array2[] = {100,500};
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                fillArr(array2[i], list);
                long start = System.nanoTime();
                m.mergeSort(list);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }
    }

    private static void fillArr(int size, LinkedList list){
        Random randomGenerator = new Random();
        for (int i = 0; i < size; ++i){
            int randomInt = randomGenerator.nextInt(999999999);
            list.add(randomInt);
        }
    }
}
