package com.company.Q1Folder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainTest {

    public void test1(){
        RedBlackTree<Integer> obj = new RedBlackTree<>();
        Integer arr[] = new Integer[22];
        fillArrAscending(arr);
        for(int i = 0; i<22; i++){
            System.out.println(arr[i] + "  Elemanı Tree'ye Ekleniyor.\n");
            obj.add(arr[i]);
            System.out.println(obj);
        }
    }

    public void test2(){
        RedBlackTree<Integer> obj = new RedBlackTree<>();
        Integer arr[] = new Integer[22];
        fillArrDescending(arr);
        for(int i = 0; i<22; i++){
            System.out.println(arr[i] + "  Elemanı Tree'ye Ekleniyor.\n");
            obj.add(arr[i]);
            System.out.println(obj);
        }
    }

    private static void fillArrDescending(Integer arr[]){
        Random randomGenerator = new Random();
        for (int i = 0; i < arr.length; ++i){
            int randomInt = randomGenerator.nextInt(9999);
            arr[i]=randomInt;
        }
        Arrays.sort(arr, Collections.reverseOrder());
    }

    private static void fillArrAscending(Integer arr[]){
        Random randomGenerator = new Random();
        for (int i = 0; i < arr.length; ++i){
            int randomInt = randomGenerator.nextInt(9999);
            arr[i]=randomInt;
        }
        Arrays.sort(arr);
    }
}
