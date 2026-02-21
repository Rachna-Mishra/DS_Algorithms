package Algorithms.Graph;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph {
    public void findCycle(ArrayList[] adj, int V){
        for(int i = 0; i < V; i++){
            boolean[] vis = new boolean[V];
            if(checkCycle(adj, vis, i, -1)){
                System.out.println("Cycle is Present");
                return;
            }
        }
        System.out.println("Cycle is not Present");
    }
    public boolean checkCycle(ArrayList<Edge>[] adj, boolean[] vis, int cur, int parent){
        vis[cur] = true;
        for(int i = 0; i < adj[cur].size(); i++){
            Edge neighbour = adj[cur].get(i);
            if(vis[neighbour.des] && parent != neighbour.des){
                return true;
            }
            if(!vis[neighbour.des] && checkCycle(adj,vis,neighbour.des, cur)){
                return true;
            }
        }
        return false;
    }
}
