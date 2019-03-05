package com.company.Q3Folder;

public class Maintest {
    public void test1() {
        BinaryTree<Integer> a = new BinaryTree<>();
        a.root = new BinaryTree.Node<>(5);
        a.root.right = new BinaryTree.Node<>(8);
        AVLTree<Integer> ab = new AVLTree(a);
    }

    public void test2() {
        BinaryTree<Integer> a = new BinaryTree<>();
        a.root = new BinaryTree.Node<>(5);
        AVLTree<Integer> ab = new AVLTree(a);
    }
}
