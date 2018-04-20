package com.company;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Part2<E extends Comparable> extends BinaryTree implements SearchTree {

    protected static class Node<E> implements Serializable {
        // Data Fields

        /** The information stored in this node. */
        public E data[];
        /** Reference to the left child. */
        public Part2.Node<E> left;
        /** Reference to the right child. */
        public Part2.Node<E> right;

        // Constructors
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data[]) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }

    public Part2.Node<E> rootNode;
    int dimension;
    int dimensionCounter;


    public Part2(int dimension) {
        rootNode = null;
        this.dimension = dimension;
        dimensionCounter=0;
    }

    public Part2() {
        super();

        this.dimension = 3;
        dimensionCounter = 0;
    }

    @Override
    public boolean add(Object item) {

        return add(item);
    }

    public boolean add(E item[]){
        int status = 1;
        Part2.Node<E> temp = null;
        if(rootNode == null){
            rootNode = new Part2.Node<E>(item);
            return true;
        }
        temp = rootNode;
        while(status == 1) {
            if(dimensionCounter==dimension){
                dimensionCounter=0;
            }
            if(item[dimensionCounter].compareTo(temp.data[dimensionCounter])==-1) {
                if (temp.left == null){
                    temp.left = new Part2.Node<E>(item);
                    dimensionCounter=0;
                    return true;
                }
                else{
                    temp = temp.left;
                    dimensionCounter++;
                }
            }
            else{
                if (temp.right == null){
                    temp.right = new Part2.Node<E>(item);
                    dimensionCounter=0;
                    return true;
                }
                else{
                    temp = temp.right;
                    dimensionCounter++;
                }
            }
        }
        return false;
    }


    @Override
    public boolean contains(Object target) {
        return false;
    }

    @Override
    public Object find(Object target) {
        return null;
    }

    @Override
    public Object delete(Object target) {
        return null;
    }

    @Override
    public boolean remove(Object target) {
        return false;
    }


}
