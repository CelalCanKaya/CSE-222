package com.company.Q3Folder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * ListGraph'tan extend edilen Class'ım
 */
public class Part3 extends ListGraph {

    /**
     * Constructor
     * @param numV Vertex Sayısı
     * @param directed Directed olup olmadığı
     */
    public Part3(int numV, boolean directed){
        super(numV  ,directed);
    }

    /**
     * List Graph'ı linked list şeklinde ekrana bastıran metod
     * @param graph Ekrana bastırılıcak olan graph
     */
    public void plot_graph(Graph graph){
        for(int i = 0; i<graph.getNumV(); i++){
            System.out.print(i);
            for(int k = 0; k<graph.getNumV(); k++){
                if(graph.isEdge(i,k)){
                    System.out.print("-->" + graph.getEdge(i,k).getDest());
                }
            }
            System.out.print("\n");
        }
    }

    /**
     * Graphın cycled olup olmadığını bulan fonksiyon
     * @param graph Kontrol edilen graph
     * @return Cyclesa false değilse true
     */
    public boolean is_acyclic_graph(Graph graph){
        int start = 0;
        Queue< Integer > theQueue = new LinkedList< Integer >();
        // Declare array parent and initialize its elements to �1.
        int[] parent = new int[graph.getNumV()];
        for (int i = 0; i < graph.getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator< Edge > itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    parent[neighbor] = current;
                }
                else if(parent[neighbor]==parent[current]){
                    System.out.print("Bu Bir Cyclic Graphtır.");
                    return false;
                }
                // Finished visiting current.
            }
        }
        System.out.print("Bu Bir Acyclic Graphtır.");
        return true;
    }

    /**
     * Verilen graph'ın directed/undirected oldugunu bulup döndüren fonksiyon
     * @param graph Kontrol edilecek olan graph
     * @return Undirectedsa true, directedsa false
     */
    public boolean is_undirected(Graph graph){
        for(int i = 0; i<graph.getNumV(); i++){
            for(int k = 0; k<graph.getNumV(); k++){
                if(graph.isEdge(i,k)){
                    if(k!=i && !graph.isEdge(k,i)){
                        System.out.print("Directed - Çünkü (" + graph.getEdge(i,k).getSource() + "," + graph.getEdge(i,k).getDest() + ") Edgesi Mevcutken (" + graph.getEdge(k,i).getSource() + "," +  graph.getEdge(k,i).getDest() + ") Edgesi Mevcut Değil.");
                        return false;
                    }
                }
            }
        }
        System.out.print("Undirected");
        return true;
    }

    /**
     * BFS ile traverse edildikten sonra minimum sparse graph olan bir graph döndürüyorum
     * @param graph traverse edilecek olan tree
     * @param start Hangi vertexten başlayacağını seçmek
     * @return Yeni graph
     */
    public Graph BFSSpan(Graph graph, int start){
        ArrayList<Edge> edges;
        edges = BreadthFirstSearch.breadthFirstSearch(graph, start);
        ListGraph temp = new ListGraph(graph.getNumV(), false);
        while(!edges.isEmpty()){
            temp.insert(edges.get(0));
            edges.remove(0);
        }
        return temp;
    }

    /**
     * DFS ile traverse edildikten sonra minimum sparse graph olan bir graph döndürüyorum
     * @param graph traverse edilecek olan tree
     * @return Yeni graph
     */
    public Graph DFSSpan(Graph graph){
        ArrayList<Edge> edges;
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        edges = dfs.getEdges();
        ListGraph temp = new ListGraph(graph.getNumV(), false);
        while(!edges.isEmpty()){
            temp.insert(edges.get(0));
            edges.remove(0);
        }
        return temp;
    }
}
