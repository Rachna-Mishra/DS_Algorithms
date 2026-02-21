package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;

//Adjacency List
//Adjacency Matrix
//Edge List
//Implicit Algorithms.Graph(2D matrix)

public class CreateGraph {
    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge>[] graph = createGraph(V);

        // BFS Algo - O(V + E)
        System.out.println("-----------BFS -------------");
        boolean[] vis = new boolean[V];
        BFSAlgo b = new BFSAlgo();
        b.bfsOfGraph(graph, vis);

        //DFS Algo - O(V + E)
        System.out.println("-----------DFS-------------");
        vis = new boolean[V];
        DFSAlgo d = new DFSAlgo();
        d.dfsOfGraph(graph, vis);

        //Print all paths from source to destination -- O(V^V)
        System.out.println("----------All Paths from Source to Dest-------------");
        vis = new boolean[V];
        String path = "";
        PrintAllPath p = new PrintAllPath();
        p.printAllPathsFromSrcToDes(graph, vis, 0, 5, path+"0");

        // Cycle Detection in Directed Algorithms.Graph USing DFS - O(V + E)
        System.out.println("----------Cycle Detection in Directed-------------");
        CycleDetectionInDirectedGraph cy = new CycleDetectionInDirectedGraph();
        cy.findCycle(graph, V);

        // Cycle Detection in UnDirected Algorithms.Graph USing DFS - O(V + E)
        System.out.println("----------Cycle Detection in Undirected -------------");
        CycleDetectionInUndirectedGraph un = new CycleDetectionInUndirectedGraph();
        un.findCycle(graph, V);

        //Topological Sort

        //Dijkstra Algorithm
        DijkstraAlgorithm da = new DijkstraAlgorithm();
        int[] distance = da.shortestDistance(V,graph,0);
        System.out.println(Arrays.toString(distance));
    }
    public static ArrayList<Edge>[] createGraph(int V){
        ArrayList<Edge>[] graph  = new ArrayList[V];
        for(int i =0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2, 1));

        graph[1].add(new Edge( 1,0,1));
        graph[1].add(new Edge( 1,3,1));

        graph[2].add(new Edge( 2,0,1));
        graph[2].add(new Edge( 2,4,1));

        graph[3].add(new Edge(3,1, 1));
        graph[3].add(new Edge(3,4, 1));
        graph[3].add(new Edge(3,5, 1));

        graph[4].add(new Edge(4, 2 ,1));
        graph[4].add(new Edge(4, 3,1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5,3 , 1));
        graph[5].add(new Edge(5,4, 1));
        graph[5].add(new Edge(5,6, 1));

        return graph;
    }

    //convert edgeList to Adjancy list
    public ArrayList<ArrayList<Integer>> makeAdjList(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<V; i++){
            ArrayList<Integer> li = new ArrayList<>();
            list.add(li);
        }
        for(int i = 0; i<edges.length; i++){
            int sc = edges[i][0];
            int d = edges[i][1];
            list.get(sc).add(d);
            list.get(d).add(sc);
        }
        return list;
    }
}
class Edge{
    int src;
    int des;
    int wt;
    Edge(int s, int d, int w){
        src = s;
        des = d;
        wt = w;
    }
}


