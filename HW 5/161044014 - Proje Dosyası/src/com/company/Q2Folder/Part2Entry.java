package com.company.Q2Folder;

/**
 * Recursive entry structure - E tipinde bir element ve collision olmasana karşılık Part2Entry tipinde yeni bir array tutan class
 * @param <E> Element
 */
public class Part2Entry<E> {
    private E element;
    private Part2Entry<E> arr[];
    int size;
    boolean isDeleted;

    /**
     * Default constructor
     */
    Part2Entry(){
        size = 0;
        isDeleted = false;
    }

    public boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Part2Entry<E>[] getArr() {
        return arr;
    }

    public void setArr(Part2Entry<E>[] arr) {
        this.arr = arr;
    }
}
