package DFS;

import java.util.*;

class GraphDFSImpl {
    private int Vert; //number of nodes
    private LinkedList<Integer>[] adj_list;  //adjacency list

    GraphDFSImpl(int Vert) {
        this.Vert = Vert;
        adj_list = new LinkedList[Vert];

        for (int i = 0; i < adj_list.length; i++) {
            adj_list[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v,int w){
        adj_list[v].add(w); //adding an edge
    }

    void DepthFirstSearch (int d){
        boolean nodes[] = new boolean[Vert];
        Stack<Integer> stack = new Stack<>();
        stack.push(d);

        while (!stack.empty()) {
            d = stack.peek();  //retrieve the top element
            stack.pop();   //remove the top element
            if (!nodes[d]) {
                System.out.println(d + " ");
                nodes[d] = true;
            }

            for (int i = 0; i < adj_list[d].size(); i++) {
                int s = adj_list[d].get(i);
                if (!nodes[s]) {
                    stack.push(s);
                }
            }
        }
    }

    public static void main (String[] args){

        GraphDFSImpl dfs = new GraphDFSImpl(8);

        System.out.println("Depth First Search");

        dfs.addEdge(0, 3);
        dfs.addEdge(3, 5);
        dfs.addEdge(5, 6);
        dfs.addEdge(6, 2);
        dfs.addEdge(2, 1);
        dfs.addEdge(3, 7);
        dfs.addEdge(7, 4);

        dfs.DepthFirstSearch(0);
    }
}
