package com.company.Q3Folder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/** Class to implement the breadth-first search algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BreadthFirstSearch {

    /** Perform a breadth-first search of a graph.
     post: The array parent will contain the predecessor
     of each vertex in the breadth-first
     search tree.
     @param graph The graph to be searched
     @param start The start vertex
     @return The array of parents
     */
    public static ArrayList<Edge> breadthFirstSearch(Graph graph, int start) {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        int arr[] = new int[graph.getNumV()];
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<graph.getNumV(); i++){
            arr[i]=i;
        }
        // Declare array parent and initialize its elements to �1.

        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
        identified[start] = true;
        theQueue.offer(start);
        arr[start]=-1;
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator <Edge> itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                if(arr[edge.getDest()]!=-1){
                    edges.add(edge);
                    arr[edge.getDest()]=-1;
                }
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                }
            }
            // Finished visiting current.
        }
        return edges;
    }
}
