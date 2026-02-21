package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/*
If neighbour is visited, and it is also available in recursion stack that means cycle present
*/
public class CycleDetectionInDirectedGraph {
    public void findCycle(ArrayList[] adj, int V){
        for(int i = 0; i < V; i++) {
            boolean[] vis = new boolean[V];
            int[] recStack = new int[V];
            Arrays.fill(recStack, -1);
            if (checkCycle(adj, vis, 0, recStack)) {
                System.out.println("Cycle is Present");
                return;
            }
        }
        System.out.println("Cycle is Not Present");
    }
    public boolean checkCycle(ArrayList<Edge>[] adj, boolean[] vis, int cur, int[] recStack){
        vis[cur] = true;
        recStack[cur] = 1;
        for(int i = 0; i < adj[cur].size(); i++){
            Edge neighbour = adj[cur].get(i);
            if(recStack[neighbour.des] == 1){
                return true;
            }
            if(!vis[neighbour.des] && checkCycle(adj,vis,neighbour.des, recStack)){
                return true;
            }
        }
        recStack[cur]=-1;
        return false;
    }
}
