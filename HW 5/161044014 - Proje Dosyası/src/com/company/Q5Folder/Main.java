package com.company.Q5Folder;

import com.company.Q4Folder.HeapSort;
import com.company.Q4Folder.InsertionSort;
import com.company.Q4Folder.MergeSort;
import com.company.Q4Folder.QuickSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
            int array[] = {500,1000,5000,10000};
            System.out.print("\nINSERTION SORT - WORST");
            for(int i=0; i<4; i++) {
                System.out.print("\nArray Size: " + array[i] + "\n\n");
                for(int j=0; j<10; j++) {
                    Integer arr[] = new Integer[array[i]];
                    for(int a=0; a<array[i]; a++){
                        arr[a]=array[i]-a;
                    }
                    long start = System.nanoTime();
                    InsertionSort.sort(arr);
                    long finish = System.nanoTime();
                    System.out.print(finish - start + "\n");
                }
            }
            System.out.print("\nMERGE SORT - WORST");
            for(int i=0; i<4; i++) {
                System.out.print("\nArray Size: " + array[i] + "\n\n");
                for(int j=0; j<10; j++) {
                    Integer arr[] = new Integer[array[i]];
                    for(int a=0; a<array[i]; a++){
                        arr[a]=array[i]-a;
                    }
                    long start = System.nanoTime();
                    MergeSort.sort(arr);
                    long finish = System.nanoTime();
                    System.out.print(finish - start + "\n");
                }
            }
            System.out.print("\nHEAP SORT - WORST");
            for(int i=0; i<4; i++) {
                System.out.print("\nArray Size: " + array[i] + "\n\n");
                for(int j=0; j<10; j++) {
                    Integer arr[] = new Integer[array[i]];
                    for(int a=0; a<array[i]; a++){
                        arr[a]=array[i]-a;
                    }
                    long start = System.nanoTime();
                    HeapSort.sort(arr);
                    long finish = System.nanoTime();
                    System.out.print(finish - start + "\n");
                }
            }
            System.out.print("\nQUICK SORT - WORST");
            for(int i=0; i<4; i++) {
                System.out.print("\nArray Size: " + array[i] + "\n\n");
                for(int j=0; j<10; j++) {
                    Integer arr[] = new Integer[array[i]];
                    for(int a=0; a<array[i]; a++){
                        arr[a]=array[i]-a;
                    }
                    long start = System.nanoTime();
                    QuickSort.sort(arr);
                    long finish = System.nanoTime();
                    System.out.print(finish - start + "\n");
                }
            }
    }

}
