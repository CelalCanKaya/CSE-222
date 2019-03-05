package com.company.Q2Folder;

public class MainTest {

    public void test1(){
        BTree<Integer> obj = new BTree<>(6);
        obj.add(7);
        obj.add(7);
        obj.add(7);
        obj.add(7);
        obj.add(8);
        obj.add(5);
        obj.add(12);
        obj.add(15);
        System.out.print(obj);
        obj.add(17);
        System.out.print(obj);
        obj.add(22);
        obj.add(67);
        obj.add(13);
        obj.add(8);
        obj.add(25);
        obj.add(60);
        obj.add(58);
        System.out.print(obj);
        obj.add(66);
        obj.add(71);
        obj.add(82);
        obj.add(93);
        obj.add(105);
        obj.add(91);
        obj.add(11);
        obj.add(39);
        obj.add(100);
        obj.add(106);
        obj.add(107);
        System.out.print(obj);
    }

    public void test2(){
        BTree<Integer> obj = new BTree<>(4);
        for(int i = 1; i<15; i++){
            obj.add(i);
            if(i==3 || i==4 || i==14){
                System.out.print(obj);
            }
        }

    }

}
