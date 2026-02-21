package Algorithms.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    //Greedy Approach - O(E + ElogV)
    //working only for positive weights, Not working in case of negative weights
    public int[] shortestDistance(int V, ArrayList<Edge>[]  adjList, int src){
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];
        for(int i = 0; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Pair p = new Pair(src, 0);
        PriorityQueue<Pair> queue= new PriorityQueue<>();
        queue.add(p);
        while(!queue.isEmpty()){
            Pair ele = queue.remove();
            if(!vis[ele.vertex]){
                for(int i = 0; i<adjList[ele.vertex].size(); i++){
                    Edge neighbour = adjList[ele.vertex].get(i);
                    if((dist[ele.vertex] != Integer.MAX_VALUE) && (dist[ele.vertex] + neighbour.wt) < dist[neighbour.des]){
                        dist[neighbour.des] = dist[ele.vertex] + neighbour.wt;
                    }
                    queue.add(new Pair(neighbour.des, dist[neighbour.des]));
                }
            }
            vis[ele.vertex] = true;
        }
        return dist;
    }
}

class Pair implements Comparable<Pair>{
    int vertex;
    int wt;
    Pair(int v, int w){
        vertex = v;
        wt = w;
    }

    @Override
    public int compareTo(Pair p2){
        return this.wt - p2.wt;
    }
}


