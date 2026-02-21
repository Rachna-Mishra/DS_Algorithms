package Algorithms.Graph;

import java.util.ArrayList;
import java.util.List;

class ArticulationPointTarjansAlgorithm {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> aps = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] articulationPoints = new boolean[V];
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        int children = 0;
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                dfs(adj, i, vis, dt, low, -1, 0, time, articulationPoints);
            }
        }
        for(int i = 0; i<V; i++){
            if(articulationPoints[i]){
                aps.add(i);
            }
        }
        if(aps.size()==0){
            return new ArrayList<Integer>(List.of(-1));
        }
        return aps;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int cur, boolean[] vis, int[] dt, int[] low, int parent, int children, int time, boolean[] articulationPoints) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        for(int i = 0; i<adj.get(cur).size(); i++){
            int neighbour = adj.get(cur).get(i);
            if(neighbour == parent){
                continue;
            }
            else if(vis[neighbour] && neighbour!= parent){
                low[cur] = Math.min(low[cur], dt[neighbour]);
            }else{
                dfs(adj, neighbour, vis, dt, low, cur, children, time, articulationPoints);
                low[cur] = Math.min(low[cur], low[neighbour]);
                if(dt[cur] <= low[neighbour] && parent != -1){
                    articulationPoints[cur] = true;

                }
                children++;
            }
        }
        if(parent == -1 && children > 1){
            articulationPoints[cur] = true;
        }
    }
}