package com.company.Q4Folder;

import com.sun.scenario.effect.Merge;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Random;

/**
 * Average caseleri bulan class
 */
public class Main {

    public static void main(String[] args) {
        int array[] = {1000,4000,7000,10000,13000,16000,19000,22000,25000,28000};
        System.out.print("\nINSERTION SORT");
        for(int i=0; i<10; i++) {
            System.out.print("\nArray Size: " + array[i] + "\n\n");
            for(int j=0; j<10; j++) {
                Integer arr[] = new Integer[array[i]];
                fillArr(arr);
                long start = System.nanoTime();
                InsertionSort.sort(arr);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }
        System.out.print("\nMERGE SORT");
        for(int i=0; i<10; i++) {
            System.out.print("\nArray Size: " + array[i] + "\n\n");
            for(int j=0; j<10; j++) {
                Integer arr[] = new Integer[array[i]];
                fillArr(arr);
                long start = System.nanoTime();
                MergeSort.sort(arr);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }
        System.out.print("\nHEAP SORT");
        for(int i=0; i<10; i++) {
            System.out.print("\nArray Size: " + array[i] + "\n\n");
            for(int j=0; j<10; j++) {
                Integer arr[] = new Integer[array[i]];
                fillArr(arr);
                long start = System.nanoTime();
                HeapSort.sort(arr);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }
        System.out.print("\nQUICK SORT");
        for(int i=0; i<10; i++) {
            System.out.print("\nArray Size: " + array[i] + "\n\n");
            for(int j=0; j<10; j++) {
                Integer arr[] = new Integer[array[i]];
                fillArr(arr);
                long start = System.nanoTime();
                QuickSort.sort(arr);
                long finish = System.nanoTime();
                System.out.print(finish - start + "\n");
            }
        }

    }

    private static void fillArr(Integer arr[]){
        Random randomGenerator = new Random();
        for (int i = 0; i < arr.length; ++i){
            int randomInt = randomGenerator.nextInt(999999999);
            arr[i]=randomInt;
        }
    }
}
