package com.company.Q3Folder;

import com.company.Q2Folder.Part2;

public class MainTest {

    public void test(){
        System.out.print("PLOT_GRAPH\n\n");
        Part3 obj = new Part3(10, false);
        obj.insert(new Edge(1,2));
        obj.insert(new Edge(1,4));
        obj.insert(new Edge(1,0));
        obj.insert(new Edge(0,2));
        obj.insert(new Edge(0,3));
        obj.insert(new Edge(2,3));
        obj.insert(new Edge(3,5));
        obj.insert(new Edge(4,5));
        obj.insert(new Edge(5,2));
        obj.insert(new Edge(6,5));
        obj.insert(new Edge(7,6));
        obj.insert(new Edge(8,3));
        obj.insert(new Edge(9,1));
        obj.insert(new Edge(8,9));
        obj.insert(new Edge(7,8));
        obj.insert(new Edge(9,0));
        obj.plot_graph(obj);
        System.out.print("\n\n");

        System.out.print("\n\nIS_UNDIRECTED\n\n");

        obj.is_undirected(obj);

        System.out.print("\n\nIS_ACYCLIC\n\n");

        obj.is_acyclic_graph(obj);

        System.out.print("\n\nDFS SPAN TREE\n\n");

        obj.plot_graph(obj.DFSSpan(obj));

        System.out.print("\n\nBFS SPAN TREE\n\n");

        obj.plot_graph(obj.BFSSpan(obj,0));


    }

}
