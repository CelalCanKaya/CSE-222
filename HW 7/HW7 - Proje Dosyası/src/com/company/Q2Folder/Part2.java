package com.company.Q2Folder;

import java.util.*;

/**
 * ListGraph'tan extend edilen Class'ım
 */
public class Part2 extends ListGraph {

    /**
     * Constructor
     * @param numV Vertex Sayısı
     * @param directed Directed olup olmadığı
     */
    public Part2(int numV, boolean directed){
        super(numV,directed);
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
            Iterator < Edge > itr = graph.edgeIterator(current);
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
     * v1 ve v2 Arasında path olup olmadığını kontrol eden metodum
     * @param graph Kontrol edilecek olan graph'ım
     * @param v1 Vertex1
     * @param v2 Vertex2
     * @return Path varsa true, yoksa false return eden fonksiyonum
     */
    public boolean is_connected(Graph graph, int v1, int v2){
        Stack<Integer> path = new Stack<>();
        int a[] = BreadthFirstSearch.breadthFirstSearch(graph, v1);
        int tempv2 = v2;
        while(v2!=-1){
            path.push(v2);
            if(isEdge(v1,v2)){
                path.push(v1);
                System.out.print(path.pop());
                while(!path.empty()) {
                    System.out.print("->" + path.pop());
                }
                System.out.print("\n");
                return true;
            }
            v2 = a[v2];
        }
        System.out.print("(" + v1 + " " + tempv2 + ") Bu iki vertex arasında bir path yok.\n");
        return false;
    }

    /**
     * Dijkstra algoritmasını kullanarak v1 noktasından v2 noktasına olan en kısa uzaklığı bulmamızı sağlayan fonksiyon
     * @param graph Kontrol edilecek olan graph
     * @param v1 Vertex 1
     * @param v2 Vertex 2
     * @return Path üzerinden noktaları Vector şeklinde return eden metodum
     */
    public Vector<Integer> shortest_path(Graph graph, int v1, int v2){
        System.out.print("\n" + v1 + "'Den " + v2 + "'Ye Giden En Kısa Yol : " );
        Vector<Integer> result = new Vector<>();
        int a[] = new int[graph.getNumV()];
        double b[] = new double[graph.getNumV()];
        DijkstrasAlgorithm.dijkstrasAlgorithm(graph, v1, a,b);
        if(b[v2]!=Double.POSITIVE_INFINITY) {
            result.add(v2);
            int tempV2 = v2;
            while (a[tempV2] != v1) {
                result.add(a[tempV2]);
                tempV2 = a[tempV2];
            }
            result.add(v1);
            Collections.reverse(result);
        }
        System.out.print(result);
        System.out.print("      Path Weight : " + b[v2]);
        return result;
    }
}
