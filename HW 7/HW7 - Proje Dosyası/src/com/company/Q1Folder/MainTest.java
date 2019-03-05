package com.company.Q1Folder;

public class MainTest {


    public void test(){
        System.out.print("PLOT_GRAPH\n\n");
        Part1 obj = new Part1(10, true);
        obj.insert(new Edge(0,9, 4));
        obj.insert(new Edge(0,8,2));
        obj.insert(new Edge(0,7,1));
        obj.insert(new Edge(1,0,6));
        obj.insert(new Edge(1,2,8));
        obj.insert(new Edge(1,3,3));
        obj.insert(new Edge(1,6, 2));
        obj.insert(new Edge(1,7,6));
        obj.insert(new Edge(2,3,1));
        obj.insert(new Edge(3,4,8));
        obj.insert(new Edge(3,3,2));
        obj.insert(new Edge(4,4,3));
        obj.insert(new Edge(5,4, 4));
        obj.insert(new Edge(5,6,5));
        obj.insert(new Edge(6,6,1));
        obj.insert(new Edge(6,7,6));
        obj.insert(new Edge(7,8,10));
        obj.insert(new Edge(9,9,3));
        obj.insert(new Edge(9,8, 2));
        obj.insert(new Edge(6,3,5));
        obj.plot_graph(obj);

        System.out.print("\n\nIS_UNDIRECTED\n\n");

        obj.is_undirected(obj);

        System.out.print("\n\nIS_ACYCLIC\n\n");

        obj.is_acyclic_graph(obj);

        System.out.print("\n\nSHORTEST_PATH\n\n");

        obj.shortest_path(obj,1,8);
        obj.shortest_path(obj,5,3);
        obj.shortest_path(obj,1,5);

    }

    public void test2(){
        System.out.print("\n\nPLOT_GRAPH\n\n");
        Part1 obj = new Part1(10, true);
        obj.insert(new Edge(0,1, 4));
        obj.insert(new Edge(0,2,2));
        obj.insert(new Edge(2,3,1));
        obj.insert(new Edge(3,3,6));
        obj.insert(new Edge(1,3,8));
        obj.insert(new Edge(3,4,3));
        obj.insert(new Edge(5,1, 2));
        obj.insert(new Edge(0,9,6));
        obj.insert(new Edge(6,6,1));
        obj.insert(new Edge(4,7,8));
        obj.insert(new Edge(7,8,2));
        obj.insert(new Edge(8,9,3));
        obj.insert(new Edge(6,9, 4));
        obj.insert(new Edge(3,5,5));
        obj.insert(new Edge(5,6,1));
        obj.insert(new Edge(6,2,6));
        obj.insert(new Edge(7,0,10));
        obj.insert(new Edge(9,4,3));
        obj.insert(new Edge(4,6, 2));
        obj.insert(new Edge(8,6,5));
        obj.plot_graph(obj);

        System.out.print("\n\nIS_UNDIRECTED\n\n");

        obj.is_undirected(obj);

        System.out.print("\n\nIS_ACYCLIC\n\n");

        obj.is_acyclic_graph(obj);

        System.out.print("\n\nSHORTEST_PATH\n\n");

        obj.shortest_path(obj,3,6);
        obj.shortest_path(obj,5,8);
        obj.shortest_path(obj,0,4);


    }

}
