package com.company.Q3Folder;

import java.util.LinkedList;

public class MergeSortDLL<E extends Comparable> {
    public void mergeSort(LinkedList<E> list){
        if(list.size() <= 1)
            return;

        LinkedList<E> left = new LinkedList<>();
        LinkedList<E> right = new LinkedList<>();
        int middle = list.size()/2;
        int i = 0;
        for( ; i < middle ; i ++)
            left.addFirst(list.get(i));
        for( ; i < list.size() ; i ++)
            right.addFirst(list.get(i));

        mergeSort(right);
        mergeSort(left);
        mergeLists(left,right,list);
    }

    private void mergeLists(LinkedList<E> left,LinkedList<E> right,LinkedList<E> list) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                list.set(k, left.get(i));
                i++;
                k++;
            } else {
                list.set(k, right.get(j));
                j++;
                k++;
            }
        }
        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }

    }
}
