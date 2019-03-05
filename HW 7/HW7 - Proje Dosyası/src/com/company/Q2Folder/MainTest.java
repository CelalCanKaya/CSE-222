package com.company.Q2Folder;

public class MainTest {

    public void test(){
        System.out.print("PLOT_GRAPH\n\n");
        Part2 obj = new Part2(15, false);
        obj.insert(new Edge(2,3));
        obj.insert(new Edge(2,4));
        obj.insert(new Edge(4,5));
        obj.insert(new Edge(5,1));
        obj.insert(new Edge(1,0));
        obj.insert(new Edge(0,14));
        obj.insert(new Edge(13,9));
        obj.insert(new Edge(11,12));
        obj.insert(new Edge(12,10));
        obj.insert(new Edge(10,8));
        obj.insert(new Edge(7,8));
        obj.plot_graph(obj);

        System.out.print("\n\nIS_UNDIRECTED\n\n");

        obj.is_undirected(obj);

        System.out.print("\n\nIS_ACYCLIC\n\n");

        obj.is_acyclic_graph(obj);

        System.out.print("\n\nIS_CONNECTED\n\n");

        obj.is_connected(obj,0,3);
        obj.is_connected(obj,7,11);
        obj.is_connected(obj,5,13);


    }

}
