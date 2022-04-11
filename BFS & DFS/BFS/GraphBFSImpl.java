package BFS;

import java.util.*;

public class GraphBFSImpl {
    private int Vert;
    private LinkedList<Integer> adj_list[];
    private Queue<Integer> queue;

    //Create graph
    GraphBFSImpl(int vert){
        Vert = vert;
        adj_list = new LinkedList[vert];
        for (int i = 0; i < vert; i++){
            adj_list[i] = new LinkedList<>();
        }
        queue = new LinkedList<Integer>();
    }

    //Adding edges to graph
    void addEdge(int v, int w){
        adj_list[v].add(w);
    }

    //breadth First Search Algorithm
    void breadthFirstSearch(int b){
        boolean nodes[] = new boolean[Vert];

        nodes[b] = true;
        queue.add(b);

        while(queue.size() != 0){
            b = queue.poll();
            System.out.println(b);

            for (int i = 0; i<adj_list[b].size(); i++){
                int s = adj_list[b].get(i);
                if(!nodes[s]){
                    nodes[s] = true;
                    queue.add(s);
                }
            }
        }
    }

    public static void main(String[] args){

        GraphBFSImpl bfh = new GraphBFSImpl(7);
        System.out.println("Breadth First Search");

        bfh.addEdge(0, 1);
        bfh.addEdge(0, 2);
        bfh.addEdge(1, 3);
        bfh.addEdge(2, 4);
        bfh.addEdge(2, 6);
        bfh.addEdge(4, 5);
        bfh.addEdge(5, 6);

        bfh.breadthFirstSearch(0);
    }
}
